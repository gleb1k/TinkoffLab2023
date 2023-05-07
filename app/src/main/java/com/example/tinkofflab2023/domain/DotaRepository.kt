package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.local.entity.PlayerEntity

interface DotaRepository {

    suspend fun getMatchEntity(matchId: String): MatchEntity

    suspend fun getPlayerEntity(accountId: String): PlayerEntity
}
