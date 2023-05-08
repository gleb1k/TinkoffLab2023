package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.players.heroes.addHeroes
import com.example.tinkofflab2023.data.remote.response.players.matches.addHeroes
import com.example.tinkofflab2023.domain.ConstantsRepository
import com.example.tinkofflab2023.domain.PlayerRepository
import com.example.tinkofflab2023.ui.model.PlayerHeroItem

class GetPlayerHeroesUseCase(
    private val playerRepository: PlayerRepository,
    private val constantsRepository: ConstantsRepository
) : UseCase {
    suspend operator fun invoke(
        accountId: String
    ): List<PlayerHeroItem>? {
        playerRepository.getHeroes(accountId).also {
             return it?.addHeroes(constantsRepository.getHeroes())
        }
    }
}
