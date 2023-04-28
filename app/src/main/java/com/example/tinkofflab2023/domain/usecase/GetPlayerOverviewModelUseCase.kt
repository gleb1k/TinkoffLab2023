package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.ui.model.player.PlayerOverviewModel

class GetPlayerOverviewModelUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        accountId: String
    ): PlayerOverviewModel = dotaRepository.getPlayerOverviewModel(accountId)
}
