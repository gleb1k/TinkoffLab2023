package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.local.entity.toModel
import com.example.tinkofflab2023.domain.ConstantsRepository
import com.example.tinkofflab2023.domain.MatchRepository
import com.example.tinkofflab2023.ui.model.MatchModel

class GetMatchModelUseCase(
    private val matchRepository: MatchRepository,
    private val constantsRepository: ConstantsRepository
) : UseCase {

    suspend operator fun invoke(
        matchId: String
    ): MatchModel? {
        matchRepository.getEntity(matchId).also {
            if (it == null)
                return null
            return it.toModel(constantsRepository.getHeroes())
        }
    }
}
