package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.ui.fragment.match.model.MatchModel

class GetMatchModelUseCase(
    private val repository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        matchId: String
    ): MatchModel = repository.getMatchModel(matchId)
}
