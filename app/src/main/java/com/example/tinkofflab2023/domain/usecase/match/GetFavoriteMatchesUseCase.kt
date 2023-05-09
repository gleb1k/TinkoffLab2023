package com.example.tinkofflab2023.domain.usecase.match

import com.example.tinkofflab2023.domain.repository.MatchRepository

class GetFavoriteMatchesUseCase(
    private val matchRepository: MatchRepository
) {
//    suspend operator fun invoke(): List<MatchEntity>? = matchRepository.getFavorites()
}
