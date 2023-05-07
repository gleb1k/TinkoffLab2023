package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroesResponse

interface ConstantsRepository {

    suspend fun getHeroes(): HeroesResponse

//    suspend fun getItems(): ItemsResponse

}
