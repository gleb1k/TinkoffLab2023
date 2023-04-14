package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.domain.DotaRepository

class GetPlayerDataUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        accountId: String
    ): PlayerDataResponse = dotaRepository.getPlayerData(accountId)
}
