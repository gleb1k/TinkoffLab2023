package com.example.tinkofflab2023.ui.fragment.match.overview

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.GetMatchUseCase
import com.example.tinkofflab2023.domain.usecase.GetTeamsOutcomesUseCase
import com.example.tinkofflab2023.domain.usecase.GetTeamsPlayersUseCase
import kotlinx.coroutines.launch

class MatchOverviewViewModel(
    private val getMatchUseCase: GetMatchUseCase,
    private val getTeamsOutcomesUseCase: GetTeamsOutcomesUseCase,
    private val getTeamsPlayersUseCase: GetTeamsPlayersUseCase
) : ViewModel() {

//    private val _match = MutableLiveData<MatchResponse?>(null)
//    val match: LiveData<MatchResponse?>
//        get() = _match

    //todo ?
    private val _viewList = MutableLiveData<ArrayList<Any>?>(null)
    val viewList: LiveData<ArrayList<Any>?>
        get() = _viewList


    fun loadData(matchId: String) {
        viewModelScope.launch {
//            _match.value = getMatchUseCase(matchId)
            generateView(matchId)
        }
    }

    //todo как лучше генерировать лист?
    private fun generateView(matchId: String) {
        viewModelScope.launch {
            val match = getMatchUseCase(matchId)
            val players = getTeamsPlayersUseCase(matchId)
            val outcomes = getTeamsOutcomesUseCase(matchId)

            _viewList.value = ArrayList<Any>().apply {
                add(match)
                add("The Radiant")
                for (i in 0..4)
                    add(players[i])
                add(outcomes[0])
                add("The Dire")
                for (i in 5..9)
                    add(players[i])
                add(outcomes[1])
            }
        }

    }

//    fun abc() {
//        binding?.run {
//            viewModel.match.observe(viewLifecycleOwner) {
//                if (it == null) return@observe
//                with(matchHeader) {
//                    tvMatchId.text = "Match ${it.matchId}"
//                    tvMatchTime.text = Converter.matchDuration(it.duration)
//                    tvWinner.text = Converter.winSide(it.radiantWin)
//                    tvRadiantKills.text = it.radiantScore.toString()
//                    tvDireKills.text = it.direScore.toString()
//                }
//            }
//        }
//    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getMatchUseCase = DataContainer.getMatchUseCase
                val getTeamsOutcomesUseCase = DataContainer.getTeamsOutcomesUseCase
                val getTeamsPlayersUseCase = DataContainer.getTeamsPlayersUseCase
                MatchOverviewViewModel(getMatchUseCase, getTeamsOutcomesUseCase, getTeamsPlayersUseCase)
            }
        }
    }
}
