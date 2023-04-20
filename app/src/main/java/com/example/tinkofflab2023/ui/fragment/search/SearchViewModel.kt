package com.example.tinkofflab2023.ui.fragment.search

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

    private val _playersList = MutableLiveData<List<SearchResponse>?>(null)
    val playersList: LiveData<List<SearchResponse>?>
        get() = _playersList

    fun onSearchClick(name: String){
        searchPlayers(name)
    }

    private fun searchPlayers(name: String) {
        if (name.length < 3)
            //оздать отдельную лайвдату для ошибки
            //todo view.showSnackbar("Минимальная длинна никнейма 3 символа")
            //как мне вывести снак бар не имея вьюшки?
            return
        viewModelScope.launch {
            _playersList.value = searchPlayersUseCase.invoke(name)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val searchPlayersUseCase = DataContainer.searchPlayersUseCase
                SearchViewModel(searchPlayersUseCase)
            }
        }
    }

}
