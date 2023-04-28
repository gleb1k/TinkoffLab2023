package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.ui.model.match.TeamPlayerItem
import com.example.tinkofflab2023.domain.DotaRepository

class GetTeamsPlayersUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        matchId: String
    ): List<TeamPlayerItem> = dotaRepository.getTeamsPlayers(matchId)
}
