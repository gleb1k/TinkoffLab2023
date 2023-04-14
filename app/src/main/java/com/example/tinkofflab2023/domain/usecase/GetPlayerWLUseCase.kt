package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.domain.DotaRepository

class GetPlayerWLUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        accountId: String
    ): PlayerWLResponse = dotaRepository.getPlayerWL(accountId)
}
