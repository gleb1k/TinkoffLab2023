package com.example.tinkofflab2023.ui.fragment.match.overview

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.GetMatchModelUseCase
import kotlinx.coroutines.launch

class MatchOverviewViewModel(
    private val getMatchModelUseCase: GetMatchModelUseCase
) : ViewModel() {

    private val _viewList = MutableLiveData<ArrayList<Any>?>(null)
    val viewList: LiveData<ArrayList<Any>?>
        get() = _viewList


    fun loadData(matchId: String) {
        viewModelScope.launch {
            generateView(matchId)
        }
    }

    private fun generateView(matchId: String) {
        viewModelScope.launch {
            val model = getMatchModelUseCase(matchId)

            _viewList.value = ArrayList<Any>().apply {
                add(model.matchResponse)
                add("The Radiant")
                //todo nullpointer
                for (i in 0..4)
                    add(model.matchResponse.players[i])
                add(model.teamOutcomes[0])
                add("The Dire")
                for (i in 5..9)
                    add(model.matchResponse.players[i])
                add(model.teamOutcomes[0])
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getMatchOverviewModelUseCase = DataContainer.getMatchModelUseCase
                MatchOverviewViewModel(getMatchOverviewModelUseCase)
            }
        }
    }
}
