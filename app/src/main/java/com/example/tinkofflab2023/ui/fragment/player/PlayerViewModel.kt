package com.example.tinkofflab2023.ui.fragment.player

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkofflab2023.domain.usecase.player.IsPlayerFavoriteUseCase
import com.example.tinkofflab2023.domain.usecase.player.PlayerFavoriteAdderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlayerViewModel @Inject constructor(
    private val playerFavoriteAdderUseCase: PlayerFavoriteAdderUseCase,
    private val isPlayerFavoriteUseCase: IsPlayerFavoriteUseCase,
) : ViewModel() {

    private val _isFavorite = MutableLiveData<Boolean?>(null)
    val isFavorite: LiveData<Boolean?>
        get() = _isFavorite

    fun favorite(id: String, isFavorite: Boolean) {
        viewModelScope.launch {
            playerFavoriteAdderUseCase(id, isFavorite)
            _isFavorite.value = !isFavorite
        }
    }

    suspend fun getFavoriteState(id: String) {
        val temp = isPlayerFavoriteUseCase(id)
        _isFavorite.value = temp
    }

}
