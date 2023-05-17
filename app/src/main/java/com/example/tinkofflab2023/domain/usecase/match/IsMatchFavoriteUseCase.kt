package com.example.tinkofflab2023.domain.usecase.match

import com.example.tinkofflab2023.domain.repository.MatchRepository
import com.example.tinkofflab2023.domain.repository.PlayerRepository
import com.example.tinkofflab2023.domain.usecase.UseCase
import javax.inject.Inject

class IsMatchFavoriteUseCase @Inject constructor(
    private val matchRepository: MatchRepository,
) : UseCase {

    suspend operator fun invoke(
        accountId: String,
    ): Boolean = matchRepository.isFavorite(accountId)
}
