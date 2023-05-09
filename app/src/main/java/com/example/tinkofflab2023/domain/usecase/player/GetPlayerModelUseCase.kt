package com.example.tinkofflab2023.domain.usecase.player

import com.example.tinkofflab2023.data.local.entity.toModel
import com.example.tinkofflab2023.domain.repository.ConstantsRepository
import com.example.tinkofflab2023.domain.repository.PlayerRepository
import com.example.tinkofflab2023.domain.usecase.UseCase
import com.example.tinkofflab2023.ui.model.PlayerModel

class GetPlayerModelUseCase(
    private val playerRepository: PlayerRepository,
    private val constantsRepository: ConstantsRepository
) : UseCase {
    suspend operator fun invoke(
        accountId: String
    ): PlayerModel? =
        playerRepository.getEntity(accountId)?.toModel(constantsRepository.getHeroes())
}
