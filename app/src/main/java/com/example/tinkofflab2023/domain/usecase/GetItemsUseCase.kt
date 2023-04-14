package com.example.tinkofflab2023.domain.usecase

import com.example.tinkofflab2023.data.remote.response.constants.items.ItemsResponse
import com.example.tinkofflab2023.domain.DotaRepository

class GetItemsUseCase(
    private val dotaRepository: DotaRepository
): UseCase {
    suspend operator fun invoke(): ItemsResponse = dotaRepository.getItems()
}
