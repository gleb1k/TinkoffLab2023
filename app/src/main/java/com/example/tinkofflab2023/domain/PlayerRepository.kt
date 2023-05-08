package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse

interface PlayerRepository {

    suspend fun getEntity(accountId: String): PlayerEntity?

    suspend fun getHeroes(id: String): PlayerHeroesResponse?

    suspend fun getMatches(id: String): PlayerMatchesResponse?
}
