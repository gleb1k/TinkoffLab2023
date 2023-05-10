package com.example.tinkofflab2023.ui.fragment.player.matches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.player.GetPlayerMatchesUseCase
import com.example.tinkofflab2023.ui.model.PlayerMatchItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch

@HiltViewModel
class PlayerMatchesViewModel(
    private val getPlayerMatchesUseCase: GetPlayerMatchesUseCase
) : ViewModel() {

    private val _viewList = MutableLiveData<List<PlayerMatchItem>?>(null)
    val viewList: LiveData<List<PlayerMatchItem>?>
        get() = _viewList

    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?>
        get() = _error


    fun loadData(accountId: String) {
        viewModelScope.launch {
            generateView(accountId)
        }
    }

    private fun generateView(accountId: String) {
        viewModelScope.launch {
            _loading.value = true
            getPlayerMatchesUseCase(accountId).also {
                if (it == null) {
                    _error.value = "Error"
                    _viewList.value = null
                    return@also
                } else
                    _viewList.value = it
            }
            _loading.value = false
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getPlayerMatchesUseCase = DataContainer.getPlayerMatchesUseCase
                PlayerMatchesViewModel(getPlayerMatchesUseCase)
            }
        }
    }
}
