package com.example.tinkofflab2023.domain.repository

import com.example.tinkofflab2023.data.local.entity.HeroEntity

interface ConstantsRepository {

    suspend fun getHeroes(): List<HeroEntity>

//    suspend fun getItems(): ItemsResponse

}