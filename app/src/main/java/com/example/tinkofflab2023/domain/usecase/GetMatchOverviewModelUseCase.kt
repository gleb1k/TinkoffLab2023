package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.ui.model.match.MatchOverviewModel

class GetMatchOverviewModelUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        matchId: String
    ): MatchOverviewModel = dotaRepository.getMatchOverviewModel(matchId)
}
