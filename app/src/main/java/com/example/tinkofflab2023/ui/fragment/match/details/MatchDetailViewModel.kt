package com.example.tinkofflab2023.ui.fragment.match.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkofflab2023.domain.usecase.match.GetMatchModelUseCase
import com.example.tinkofflab2023.ui.util.ViewGenerator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    private val getMatchModelUseCase: GetMatchModelUseCase,
    private val viewGenerator: ViewGenerator,
) : ViewModel() {

    private val _viewList = MutableLiveData<ArrayList<Any>?>(null)
    val viewList: LiveData<ArrayList<Any>?>
        get() = _viewList

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?>
        get() = _error


    fun loadData(matchId: String) {
        viewModelScope.launch {
            generateView(matchId)
        }
    }

    private fun generateView(matchId: String) {
        viewModelScope.launch {
            _loading.value = true
            getMatchModelUseCase(matchId).also {
                if (it == null) {
                    _error.value = "Error"
                    _viewList.value = null
                    return@also
                }
                _viewList.value = viewGenerator.generateMatchDetail(it)
            }
            _loading.value = false
        }
    }
}
