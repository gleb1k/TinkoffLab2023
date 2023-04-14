package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchesResponse
import com.example.tinkofflab2023.domain.DotaRepository

class GetPlayerResentMatchesUseCase(
    private val dotaRepository: DotaRepository
): UseCase {
    suspend operator fun invoke(
        accountId: String
    ): PlayerRecentMatchesResponse = dotaRepository.getPlayerRecentMatches(accountId)
}
