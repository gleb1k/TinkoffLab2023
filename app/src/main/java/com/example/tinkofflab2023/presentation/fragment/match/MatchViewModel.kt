package com.example.tinkofflab2023.presentation.fragment.match

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.GetMatchUseCase
import kotlinx.coroutines.launch

class MatchViewModel(
    private val getMatchUseCase: GetMatchUseCase
) : ViewModel() {

    private val _match = MutableLiveData<MatchResponse?>(null)
    val match: LiveData<MatchResponse?>
        get() = _match

    private fun getMatchData(matchId: String = Constants.MATCH_TEST_ID) {
        viewModelScope.launch {
            _match.value = getMatchUseCase(matchId)
        }
    }

    fun loadData(matchId: String = Constants.MATCH_TEST_ID) {
        getMatchData(matchId)
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
