package com.example.tinkofflab2023.domain.usecase.player

import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.domain.repository.PlayerRepository
import javax.inject.Inject

class GetFavoritePlayersUseCase @Inject constructor(
    private val playerRepository: PlayerRepository
) {
    suspend operator fun invoke(): List<PlayerEntity>? = playerRepository.getFavorites()
}
