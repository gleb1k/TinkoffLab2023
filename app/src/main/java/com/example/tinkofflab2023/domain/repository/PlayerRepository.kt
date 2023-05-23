package com.example.tinkofflab2023.domain.repository

import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse

interface PlayerRepository {

    suspend fun getEntity(id: String): PlayerEntity?

    suspend fun getHeroes(id: String): PlayerHeroesResponse?

    suspend fun getMatches(id: String): PlayerMatchesResponse?

    suspend fun addToFavorite(id: String)

    suspend fun removeFromFavorite(id: String)

    suspend fun isFavorite(id: String): Boolean

    suspend fun getFavorites(): List<PlayerEntity>?

    suspend fun refresh(id: String)

}
