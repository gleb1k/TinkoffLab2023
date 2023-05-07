package com.example.tinkofflab2023.ui.fragment.player.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.core.util.Resource
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.repository.DotaRepositoryImpl
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.domain.usecase.GetPlayerModelUseCase
import kotlinx.coroutines.launch

class PlayerOverviewViewModel(
    private val getPlayerModelUseCase: GetPlayerModelUseCase,
    private val repository: DotaRepositoryImpl
) : ViewModel() {

//    val player = repository.getPlayer("324").asLiveData()

    private val _viewList = MutableLiveData<ArrayList<Any>?>(null)
    val viewList: LiveData<ArrayList<Any>?>
        get() = _viewList

    private val _player = MutableLiveData<Resource<PlayerEntity>>()
    val player: LiveData<Resource<PlayerEntity>>
        get() = _player

    fun loadData(accountId: String) {
        viewModelScope.launch {
            generateView(accountId)
        }
    }

    fun getPlayer(accountId: String) {
        _player.value = repository.getPlayer(accountId).asLiveData().value
    }

    private fun generateView(accountId: String) {
        viewModelScope.launch {
            val model = getPlayerModelUseCase(accountId)
            _viewList.value = ArrayList<Any>(13).apply {
                add(model.header)
                add("Latest Matches")
                if (model.recentMatches.size >= 5) {
                    for (i in 0..4)
                        add(model.recentMatches[i])
                } else
                    add("Matches doesn't found")
                if (model.heroes.size >= 5) {
                    add("Most played Heroes")
                    for (i in 0..4)
                        add(model.heroes[i])
                } else
                    add("Matches doesn't found")
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getPlayerOverviewModelUseCase = DataContainer.getPlayerModelUseCase

                PlayerOverviewViewModel(
                    getPlayerOverviewModelUseCase,
                    DataContainer.dotaRepositoryImpl
                )
            }
        }
    }
}
