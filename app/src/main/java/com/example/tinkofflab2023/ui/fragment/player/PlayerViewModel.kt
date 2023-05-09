package com.example.tinkofflab2023.ui.fragment.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.player.IsPlayerFavoriteUseCase
import com.example.tinkofflab2023.domain.usecase.player.PlayerFavoriteAdderUseCase
import kotlinx.coroutines.launch

class PlayerViewModel(
    private val playerFavoriteAdderUseCase: PlayerFavoriteAdderUseCase,
    private val isPlayerFavoriteUseCase: IsPlayerFavoriteUseCase,
) : ViewModel() {

    private val _isFavorite = MutableLiveData<Boolean?>(null)
    val isFavorite: LiveData<Boolean?>
        get() = _isFavorite

    fun favorite(id: String,isFavorite:Boolean) {
        viewModelScope.launch {
            playerFavoriteAdderUseCase(id,isFavorite)
            _isFavorite.value = !isFavorite
        }
    }
    fun getFavoriteState(id: String) {
        viewModelScope.launch {
            _isFavorite.value = isPlayerFavoriteUseCase(id)
            val temp =  _isFavorite.value
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val playerFavoriteUseCase = DataContainer.playerFavoriteAdderUseCase
                val isPlayerFavoriteUseCase = DataContainer.isPlayerFavoriteUseCase
                PlayerViewModel(
                    playerFavoriteUseCase,
                    isPlayerFavoriteUseCase
                )
            }
        }
    }
}
