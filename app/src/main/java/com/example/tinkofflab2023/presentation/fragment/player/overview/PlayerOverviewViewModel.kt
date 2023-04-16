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

    //вот эти лайвдаты поидее не нужны
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

    //todo ?
    private val _viewList = MutableLiveData<ArrayList<Any>?>(null)
    val viewList: LiveData<ArrayList<Any>?>
        get() = _viewList

    //todo если делать все это в разных viewModelScope, то падает nullPointer, тк
    //данные не успеваю подгрузиться, а я уже их собираю в массив
    //ВОПРОС: Как сделать красивее и эффективнее?
    //ВОПРОС(1): Нужны ли лайвдаты под остальные переменные? или можно обойтись полями?
    fun loadData(accountId: String) {
        viewModelScope.launch {
            _playerData.value = getPlayerDataUseCase(accountId)
            _playerWL.value = getPlayerWLUseCase(accountId)
            _playerResentMatches.value = getPlayerResentMatchesUseCase(accountId)
            _playerHeroes.value = getPlayerHeroesUseCase(accountId)
            generateView()
        }
    }

    //todo вот так когда делаю падает nullPointer
//    fun loadData(accountId: String) {
//        if (accountId == "")
//            return
//        getPlayerData(accountId)
//        getPlayerWL(accountId)
//        getPlayerRecentMatches(accountId)
//        getPlayerHeroes(accountId)
//        generateView()
//    }

    //todo как красиво генерить список?
    //жеско насрал
    private fun generateView() {
        _viewList.value = ArrayList<Any>(13).apply {
            //todo проверка на нулЛ?
            add(playerData.value!!)
            add("Recent Matches")
            for (i in 0 .. 4)
                add(playerResentMatches.value!![i])
            add("Most played Heroes")
            for (i in 0 .. 4)
                add(playerHeroes.value!![i])
        }
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
