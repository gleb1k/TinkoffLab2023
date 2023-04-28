package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.domain.DotaRepository

class SearchPlayersUseCase(
    private val dotaRepository: DotaRepository
) : UseCase {
    suspend operator fun invoke(
        name: String
    ): List<SearchPlayerResponse> = dotaRepository.searchPlayers(name)
}
