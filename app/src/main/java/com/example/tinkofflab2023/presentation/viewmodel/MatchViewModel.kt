package com.example.tinkofflab2023.presentation.viewmodel

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.GetMatchUseCase
import kotlinx.coroutines.launch

class MatchViewModel(
    private val getMatchUseCase: GetMatchUseCase
) : ViewModel() {

    private val _matchResponse = MutableLiveData<MatchResponse?>(null)
    val matchResponse: LiveData<MatchResponse?>
        get() = _matchResponse

    private fun getMatchData(matchId: String = Constants.test_id) {
        viewModelScope.launch {
            _matchResponse.value = getMatchUseCase(matchId)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getMatchUseCase = DataContainer.getMatchUseCase
                MatchViewModel(getMatchUseCase)
            }
        }
    }
}
