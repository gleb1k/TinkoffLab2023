package com.example.tinkofflab2023.presentation.fragment.player.overview

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.GetPlayerDataUseCase
import com.example.tinkofflab2023.domain.usecase.GetPlayerHeroesUseCase
import com.example.tinkofflab2023.domain.usecase.GetPlayerResentMatchesUseCase
import com.example.tinkofflab2023.domain.usecase.GetPlayerWLUseCase
import kotlinx.coroutines.launch

class PlayerOverviewViewModel(
    private val getPlayerHeroesUseCase: GetPlayerHeroesUseCase,
    private val getPlayerResentMatchesUseCase: GetPlayerResentMatchesUseCase,
    private val getPlayerWLUseCase: GetPlayerWLUseCase,
    private val getPlayerDataUseCase: GetPlayerDataUseCase
) : ViewModel() {

    private val _playerData = MutableLiveData<PlayerDataResponse?>(null)
    val playerData: LiveData<PlayerDataResponse?>
        get() = _playerData

    private val _playerWL = MutableLiveData<PlayerWLResponse?>(null)
    val playerWL: LiveData<PlayerWLResponse?>
        get() = _playerWL

    private val _playerResentMatches = MutableLiveData<PlayerRecentMatchesResponse?>(null)
    val playerResentMatches: LiveData<PlayerRecentMatchesResponse?>
        get() = _playerResentMatches

    private val _playerHeroes = MutableLiveData<PlayerHeroesResponse?>(null)
    val playerHeroes: LiveData<PlayerHeroesResponse?>
        get() = _playerHeroes

    private fun getPlayerData(accountId: String) {
        viewModelScope.launch {
            _playerData.value = getPlayerDataUseCase(accountId)
        }
    }

    private fun getPlayerWL(accountId: String) {
        viewModelScope.launch {
            _playerWL.value = getPlayerWLUseCase(accountId)
        }
    }

    private fun getPlayerRecentMatches(accountId: String) {
        viewModelScope.launch {
            _playerResentMatches.value = getPlayerResentMatchesUseCase(accountId)
        }
    }

    private fun getPlayerHeroes(accountId: String) {
        viewModelScope.launch {
            _playerHeroes.value = getPlayerHeroesUseCase(accountId)
        }
    }

    fun loadData(accountId: String) {
        getPlayerData(accountId)
        getPlayerWL(accountId)
        getPlayerRecentMatches(accountId)
        getPlayerHeroes(accountId)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getPlayerHeroesUseCase = DataContainer.getPlayerHeroesUseCase
                val getPlayerResentMatchesUseCase = DataContainer.getPlayerResentMatchesUseCase
                val getPlayerWLUseCase = DataContainer.getPlayerWLUseCase
                val getPlayerDataUseCase = DataContainer.getPlayerDataUseCase
                PlayerOverviewViewModel(
                    getPlayerHeroesUseCase,
                    getPlayerResentMatchesUseCase,
                    getPlayerWLUseCase,
                    getPlayerDataUseCase
                )
            }
        }
    }
}
