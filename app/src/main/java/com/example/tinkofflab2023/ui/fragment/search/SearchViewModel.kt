package com.example.tinkofflab2023.ui.fragment.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.domain.usecase.GetMatchUseCase
import com.example.tinkofflab2023.domain.usecase.SearchPlayersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchPlayersUseCase: SearchPlayersUseCase,
    private val getMatchUseCase: GetMatchUseCase
) : ViewModel() {

    private val _viewList = MutableLiveData<ArrayList<Any>?>(null)
    val viewList: LiveData<ArrayList<Any>?>
        get() = _viewList

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?>
        get() = _error


    fun onSearchClick(query: String?) {
        generateList(query)
    }

    private fun generateList(query: String?) {
        if (query.isNullOrBlank()) {
            _error.value = "Enter something"
            return
        }
        viewModelScope.launch {
            _loading.value = true
            val list = ArrayList<Any>().apply {
                searchMatch(query)?.also {
                    add(it)
                }
                searchPlayers(query).also {
                    addAll(it)
                }
            }
            _viewList.value = list
            _loading.value = false
        }
    }

    private suspend fun searchPlayers(name: String): List<SearchPlayerResponse> {
        if (name.length < 3) {
            _error.value = "Min query length = 3"
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


}
