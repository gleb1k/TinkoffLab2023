package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.domain.DotaRepository

class GetMatchUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        matchId: String
    ): MatchResponse = dotaRepository.getMatch(matchId)
}
