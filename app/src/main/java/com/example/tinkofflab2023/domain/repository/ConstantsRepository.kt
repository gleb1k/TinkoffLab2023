package com.example.tinkofflab2023.domain.repository

import com.example.tinkofflab2023.data.local.entity.HeroEntity
import com.example.tinkofflab2023.data.local.entity.ItemEntity

interface ConstantsRepository {

    suspend fun getHeroes(): List<HeroEntity>

    suspend fun getItems(): List<ItemEntity>

}
