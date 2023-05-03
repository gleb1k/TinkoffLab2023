package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.ui.model.player.PlayerEntity

class GetPlayerModelUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        accountId: String
    ): PlayerEntity = dotaRepository.getPlayerModel(accountId)
}
