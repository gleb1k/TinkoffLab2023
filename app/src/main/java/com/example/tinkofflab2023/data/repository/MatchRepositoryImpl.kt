package com.example.tinkofflab2023.data.repository

import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.domain.MatchRepository
import com.example.tinkofflab2023.domain.PlayerRepository

class MatchRepositoryImpl(
    private val db: AppDatabase,
    private val api: DotaApi
) : MatchRepository {

    private val matchDao = db.getMatchDao()

    override suspend fun getEntity(matchId: String): MatchEntity? {
        matchDao.get(matchId)?.let {
            return it
        }
        try {
            return MatchEntity(
                api.getMatch(matchId)
            ).also {
                matchDao.insert(it)
            }
        } catch (throwable: Throwable) {
            return null
        }
    }

}
