package com.example.tinkofflab2023.ui.fragment.player.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.player.GetPlayerHeroesUseCase
import com.example.tinkofflab2023.ui.model.PlayerHeroItem
import kotlinx.coroutines.launch

class PlayerHeroesViewModel(
    private val getPlayerHeroesUseCase: GetPlayerHeroesUseCase,
) : ViewModel() {

    private val _viewList = MutableLiveData<List<PlayerHeroItem>?>(null)
    val viewList: LiveData<List<PlayerHeroItem>?>
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
            getPlayerHeroesUseCase(accountId).also {
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
                val getPlayerHeroesUseCase = DataContainer.getPlayerHeroesUseCase
                PlayerHeroesViewModel(getPlayerHeroesUseCase)
            }
        }
    }
}
