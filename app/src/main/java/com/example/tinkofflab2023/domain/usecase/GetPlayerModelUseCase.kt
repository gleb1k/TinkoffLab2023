package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.local.entity.toModel
import com.example.tinkofflab2023.domain.ConstantsRepository
import com.example.tinkofflab2023.domain.PlayerRepository
import com.example.tinkofflab2023.ui.model.PlayerModel

class GetPlayerModelUseCase(
    private val playerRepository: PlayerRepository,
    private val constantsRepository: ConstantsRepository
) : UseCase {
    suspend operator fun invoke(
        accountId: String
    ): PlayerModel? {
        playerRepository.getEntity(accountId).also {
            if (it == null)
                return null
            return it.toModel(constantsRepository.getHeroes())
        }
    }
}
