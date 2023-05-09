package com.example.tinkofflab2023.domain.usecase.player

import com.example.tinkofflab2023.domain.repository.PlayerRepository
import com.example.tinkofflab2023.domain.usecase.UseCase

class IsPlayerFavoriteUseCase(
    private val playerRepository: PlayerRepository,
) : UseCase {

    suspend operator fun invoke(
        accountId: String,
    ): Boolean = playerRepository.isFavorite(accountId)
}
