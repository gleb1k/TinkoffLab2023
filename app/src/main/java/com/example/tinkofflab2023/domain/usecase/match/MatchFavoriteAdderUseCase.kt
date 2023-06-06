package com.example.tinkofflab2023.domain.usecase.match

import com.example.tinkofflab2023.domain.repository.MatchRepository
import com.example.tinkofflab2023.domain.usecase.UseCase
import javax.inject.Inject

class MatchFavoriteAdderUseCase @Inject constructor(
    private val matchRepository: MatchRepository
) : UseCase {

    suspend operator fun invoke(
        accountId: String,
        isFavorite: Boolean,
    ) {
        if (isFavorite)
            matchRepository.removeFromFavorite(accountId)
        else
            matchRepository.addToFavorite(accountId)
    }
}
