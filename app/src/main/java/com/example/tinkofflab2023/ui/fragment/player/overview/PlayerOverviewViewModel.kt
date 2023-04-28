package com.example.tinkofflab2023.ui.fragment.player.overview

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.*
import kotlinx.coroutines.launch

class PlayerOverviewViewModel(
    private val getPlayerOverviewModelUseCase: GetPlayerOverviewModelUseCase,
) : ViewModel() {

    private val _viewList = MutableLiveData<ArrayList<Any>?>(null)
    val viewList: LiveData<ArrayList<Any>?>
        get() = _viewList

    fun loadData(accountId: String) {
        viewModelScope.launch {
            generateView(accountId)
        }
    }

    //todo как красиво генерить список?
    //жеско насрал
    private fun generateView(accountId: String) {
        viewModelScope.launch {
            val model = getPlayerOverviewModelUseCase(accountId)
            _viewList.value = ArrayList<Any>(13).apply {
                add(model.header)
                add("Latest Matches")
                for (i in 0..4)
                    add(model.recentMatches[i])
                add("Most played Heroes")
                for (i in 0..4)
                    add(model.heroes[i])
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getPlayerOverviewModelUseCase = DataContainer.getPlayerOverviewModelUseCase

                PlayerOverviewViewModel(
                    getPlayerOverviewModelUseCase,
                )
            }
        }
    }
}
