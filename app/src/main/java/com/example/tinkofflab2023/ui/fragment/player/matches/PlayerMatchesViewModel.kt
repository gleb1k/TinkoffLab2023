package com.example.tinkofflab2023.ui.fragment.player.matches

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.ui.fragment.player.overview.PlayerOverviewViewModel

class PlayerMatchesViewModel: ViewModel() {



    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
//                val getPlayerOverviewModelUseCase = DataContainer.getPlayerModelUseCase

                PlayerMatchesViewModel()
            }
        }
    }
}
