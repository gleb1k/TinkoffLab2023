package com.example.tinkofflab2023.presentation

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.SearchPlayersUseCase
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchPlayersUseCase: SearchPlayersUseCase
) : ViewModel() {

    private val _playersList = MutableLiveData<ArrayList<SearchResponse>?>(null)
    val playersList: LiveData<ArrayList<SearchResponse>?>
        get() = _playersList

    private fun searchPlayers(name: String){
        viewModelScope.launch {
            _playersList.value = searchPlayersUseCase.invoke(name)
        }
    }

    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
               val searchPlayersUseCase = DataContainer.searchPlayersUseCase

            }
        }

    }

}