package com.example.tinkofflab2023.domain.repository

import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchResponse

interface PlayerRepository {

    suspend fun getEntity(accountId: String): PlayerEntity?

    suspend fun getHeroes(id: String): List<PlayerHeroResponse>?

    suspend fun getMatches(id: String): List<PlayerMatchResponse>?

    suspend fun addToFavorite(id: String)

    suspend fun removeFromFavorite(id: String)

    suspend fun isFavorite(id: String): Boolean

    suspend fun getFavorites(): List<PlayerEntity>?

}
