package com.example.tinkofflab2023.ui.fragment.player.heroes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class PlayerHeroesViewModel : ViewModel() {


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
//                val getPlayerOverviewModelUseCase = DataContainer.getPlayerModelUseCase

                PlayerHeroesViewModel()
            }
        }
    }
}
