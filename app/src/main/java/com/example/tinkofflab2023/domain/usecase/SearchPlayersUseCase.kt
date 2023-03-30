package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.search.SearchResponse
import com.example.tinkofflab2023.domain.DotaRepository

class SearchPlayersUseCase(
    private val dotaRepository: DotaRepository
) {
    suspend operator fun invoke(
        name: String
    ): List<SearchResponse> = dotaRepository.searchPlayers(name)
}
