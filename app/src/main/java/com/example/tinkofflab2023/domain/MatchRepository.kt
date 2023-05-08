package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.data.local.entity.MatchEntity

interface MatchRepository {

    suspend fun getEntity(matchId: String): MatchEntity?
}
