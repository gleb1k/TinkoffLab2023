package com.example.tinkofflab2023.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.tinkofflab2023.di.DataContainer
import com.example.tinkofflab2023.domain.usecase.GetMatchUseCase

class MatchViewModel(
    private val getMatchUseCase: GetMatchUseCase
) : ViewModel() {



    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val getMatchUseCase = DataContainer.getMatchUseCase
                MatchViewModel(getMatchUseCase)
            }
        }
    }
}
