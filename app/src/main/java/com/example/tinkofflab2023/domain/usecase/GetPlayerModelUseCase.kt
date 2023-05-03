package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.ui.fragment.player.model.PlayerModel

class GetPlayerModelUseCase(
    private val repository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        accountId: String
    ): PlayerModel = repository.getPlayerModel(accountId)
}