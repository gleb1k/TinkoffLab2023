package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroesResponse
import com.example.tinkofflab2023.domain.DotaRepository

class GetHeroesUseCase(
    private val dotaRepository: DotaRepository
) {
    suspend operator fun invoke(): HeroesResponse = dotaRepository.getHeroes()
}
