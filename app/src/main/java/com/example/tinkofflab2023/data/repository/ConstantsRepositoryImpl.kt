package com.example.tinkofflab2023.data.repository

import androidx.room.Room
import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroesResponse
import com.example.tinkofflab2023.domain.ConstantsRepository

class ConstantsRepositoryImpl(
    private val db: AppDatabase,
    private val api: DotaApi
): ConstantsRepository {

    override suspend fun getHeroes(): HeroesResponse {
        TODO("Not yet implemented")
    }

}
