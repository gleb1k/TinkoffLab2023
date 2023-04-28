package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.ui.model.match.TeamOutcomeItem
import com.example.tinkofflab2023.domain.DotaRepository

class GetTeamsOutcomesUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        matchId: String
    ): List<TeamOutcomeItem> = dotaRepository.getTeamsOutcomes(matchId)
}
