package com.example.tinkofflab2023.ui.fragment.match.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.match.GetMatchModelUseCase
import com.example.tinkofflab2023.ui.generateMatchOverview
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class MatchOverviewViewModel(
    private val getMatchModelUseCase: GetMatchModelUseCase
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
                _viewList.value = generateMatchOverview(it)
            }
            _loading.value = false
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getMatchOverviewModelUseCase = DataContainer.getMatchModelUseCase
                MatchOverviewViewModel(getMatchOverviewModelUseCase)
            }
        }
    }
}
