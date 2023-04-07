package com.example.tinkofflab2023.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.GetPlayerDataUseCase
import com.example.tinkofflab2023.domain.usecase.GetPlayerHeroesUseCase
import com.example.tinkofflab2023.domain.usecase.GetPlayerResentMatchesUseCase
import com.example.tinkofflab2023.domain.usecase.GetPlayerWLUseCase

class PlayerViewModel(
    private val getPlayerHeroesUseCase: GetPlayerHeroesUseCase,
    private val getPlayerResentMatchesUseCase: GetPlayerResentMatchesUseCase,
    private val getPlayerWLUseCase: GetPlayerWLUseCase,
    private val getPlayerDataUseCase: GetPlayerDataUseCase
) : ViewModel() {


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getPlayerHeroesUseCase = DataContainer.getPlayerHeroesUseCase
                val getPlayerResentMatchesUseCase = DataContainer.getPlayerResentMatchesUseCase
                val getPlayerWLUseCase = DataContainer.getPlayerWLUseCase
                val getPlayerDataUseCase = DataContainer.getPlayerDataUseCase
                PlayerViewModel(
                    getPlayerHeroesUseCase,
                    getPlayerResentMatchesUseCase,
                    getPlayerWLUseCase,
                    getPlayerDataUseCase
                )
            }
        }
    }
}
