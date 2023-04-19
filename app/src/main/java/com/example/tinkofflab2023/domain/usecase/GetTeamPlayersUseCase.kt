package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.model.TeamPlayer
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.domain.DotaRepository

class GetTeamPlayersUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        matchId: String
    ): List<TeamPlayer> = dotaRepository.getTeamPlayers(matchId)
}