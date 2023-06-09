package com.example.tinkofflab2023.domain.usecase.player

import com.example.tinkofflab2023.domain.repository.PlayerRepository
import com.example.tinkofflab2023.domain.usecase.UseCase
import javax.inject.Inject

class PlayerFavoriteAdderUseCase @Inject constructor(
    private val playerRepository: PlayerRepository,
) : UseCase {

    suspend operator fun invoke(
        accountId: String,
        isFavorite: Boolean,
    ) {
        if (isFavorite)
            playerRepository.removeFromFavorite(accountId)
        else
            playerRepository.addToFavorite(accountId)
    }
}
