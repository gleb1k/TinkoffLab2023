package com.example.tinkofflab2023.domain.usecase.player

import com.example.tinkofflab2023.data.remote.response.players.heroes.addHeroes
import com.example.tinkofflab2023.domain.repository.ConstantsRepository
import com.example.tinkofflab2023.domain.repository.PlayerRepository
import com.example.tinkofflab2023.domain.usecase.UseCase
import com.example.tinkofflab2023.ui.model.PlayerHeroItem
import javax.inject.Inject

class GetPlayerHeroesUseCase @Inject constructor(
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
