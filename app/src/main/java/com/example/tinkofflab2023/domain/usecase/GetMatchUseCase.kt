package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.core.util.isNumeric
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.domain.repository.SearchRepository
import com.example.tinkofflab2023.domain.usecase.UseCase

class GetMatchUseCase(
    private val searchRepository: SearchRepository
) : UseCase {
    suspend operator fun invoke(
        matchId: String
    ): MatchResponse {
        if (matchId.isNumeric())
            return searchRepository.getMatch(matchId)
        else
            throw IllegalArgumentException()
    }

}

