package com.example.tinkofflab2023.domain.repository

import com.example.tinkofflab2023.data.local.entity.MatchEntity

interface MatchRepository {

    suspend fun getEntity(matchId: String): MatchEntity?

    suspend fun addToFavorite(id:String)

    suspend fun removeFromFavorite(id:String)

    suspend fun isFavorite(id:String) : Boolean

    suspend fun getFavorites() : List<MatchEntity>?
}
