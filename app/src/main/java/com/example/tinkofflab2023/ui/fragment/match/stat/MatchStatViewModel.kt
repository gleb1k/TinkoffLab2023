package com.example.tinkofflab2023.ui.fragment.match.stat

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkofflab2023.domain.usecase.match.GetMatchModelUseCase
import com.example.tinkofflab2023.ui.model.MatchModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MatchStatViewModel @Inject constructor(
    private val getMatchModelUseCase: GetMatchModelUseCase,
) : ViewModel() {

    private val _match = MutableLiveData<MatchModel?>(null)
    val match: LiveData<MatchModel?>
        get() = _match

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?>
        get() = _error


    fun loadData(matchId: String) {
        viewModelScope.launch {
            try {
                _loading.value = true
                _match.value = getMatchModelUseCase(matchId)
                _loading.value = false
            } catch (thr: Throwable) {
                _error.value = "Error"
            }
        }
    }
}
