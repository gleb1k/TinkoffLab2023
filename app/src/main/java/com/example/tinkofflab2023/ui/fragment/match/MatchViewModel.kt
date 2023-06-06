package com.example.tinkofflab2023.ui.fragment.match

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkofflab2023.domain.usecase.match.IsMatchFavoriteUseCase
import com.example.tinkofflab2023.domain.usecase.match.MatchFavoriteAdderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val matchFavoriteAdderUseCase: MatchFavoriteAdderUseCase,
    private val isMatchFavoriteUseCase: IsMatchFavoriteUseCase,
) : ViewModel() {

    private val _isFavorite = MutableLiveData<Boolean?>(null)
    val isFavorite: LiveData<Boolean?>
        get() = _isFavorite

    fun favorite(id: String, isFavorite: Boolean) {
        viewModelScope.launch {
            matchFavoriteAdderUseCase(id, isFavorite)
            _isFavorite.value = !isFavorite
        }
    }

    suspend fun getFavoriteState(id: String) {
        val temp = isMatchFavoriteUseCase(id)
        _isFavorite.value = temp
    }

}
