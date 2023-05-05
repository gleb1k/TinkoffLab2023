package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.domain.SearchRepository

class GetMatchUseCase(
    private val searchRepository: SearchRepository
) : UseCase {
    suspend operator fun invoke(
        matchId: String
    ): MatchResponse = searchRepository.getMatch(matchId)
}
