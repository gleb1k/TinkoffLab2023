package com.example.tinkofflab2023.domain.usecase.match

import com.example.tinkofflab2023.data.local.entity.toModel
import com.example.tinkofflab2023.domain.repository.ConstantsRepository
import com.example.tinkofflab2023.domain.repository.MatchRepository
import com.example.tinkofflab2023.domain.usecase.UseCase
import com.example.tinkofflab2023.ui.model.MatchModel

class GetMatchModelUseCase(
    private val matchRepository: MatchRepository,
    private val constantsRepository: ConstantsRepository
) : UseCase {

    suspend operator fun invoke(
        matchId: String
    ): MatchModel? =
        matchRepository.getEntity(matchId)?.toModel(constantsRepository.getHeroes())
}
