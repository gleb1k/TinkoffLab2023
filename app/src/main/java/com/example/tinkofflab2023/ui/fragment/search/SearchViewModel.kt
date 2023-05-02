package com.example.tinkofflab2023.ui.fragment.search

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.GetMatchUseCase
import com.example.tinkofflab2023.domain.usecase.SearchPlayersUseCase
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchPlayersUseCase: SearchPlayersUseCase,
    private val getMatchUseCase: GetMatchUseCase
) : ViewModel() {

    private val _viewList = MutableLiveData<ArrayList<Any>?>(null)
    val viewList: LiveData<ArrayList<Any>?>
        get() = _viewList

    private val _error = MutableLiveData<Boolean>(false)
    val error: LiveData<Boolean>
        get() = _error


    fun onSearchClick(query: String?) {
        generateList(query)
    }

    private fun generateList(query: String?) {
        if (query == null)
            return

        viewModelScope.launch {
            val list = ArrayList<Any>().apply {
                searchMatch(query)?.also {
                    add(it)
                }
                searchPlayers(query).also {
                    addAll(it)
                }
            }
            _viewList.value = list
        }
    }

    private suspend fun searchPlayers(name: String): List<SearchPlayerResponse> {
        if (name.length < 3) {
            _error.value = true
            return listOf()
        }
        return searchPlayersUseCase(name)
    }

    private suspend fun searchMatch(matchId: String): MatchResponse? {
        return try {
            getMatchUseCase(matchId)
        } catch (ex: Throwable) {
            null
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val searchPlayersUseCase = DataContainer.searchPlayersUseCase
                val getMatchUseCase = DataContainer.getMatchUseCase
                SearchViewModel(searchPlayersUseCase, getMatchUseCase)
            }
        }
    }

}
