package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.domain.SearchRepository

class SearchPlayersUseCase(
    private val searchRepository: SearchRepository
) : UseCase {
    suspend operator fun invoke(
        name: String
    ): List<SearchPlayerResponse> = searchRepository.searchPlayers(name)
}
