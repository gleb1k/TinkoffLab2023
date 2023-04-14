package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.domain.DotaRepository

class GetPlayerHeroesUseCase(
    private val dotaRepository: DotaRepository
): UseCase {
    suspend operator fun invoke(
        accountId: String
    ): PlayerHeroesResponse = dotaRepository.getPlayerHeroes(accountId)
}
