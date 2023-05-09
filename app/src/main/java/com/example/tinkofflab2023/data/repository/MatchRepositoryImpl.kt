package com.example.tinkofflab2023.data.repository

import androidx.room.withTransaction
import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.domain.repository.MatchRepository

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
                addToCache(it)
            }
        } catch (throwable: Throwable) {
            return null
        }
    }

    /**
     *  If cache entities is more than 3 -> delete them all
     */
    private suspend fun addToCache(match: MatchEntity) {
        if (matchDao.countCache() >= 3) {
            db.withTransaction {
                matchDao.clearCache()
                matchDao.insert(match)
            }
        } else {
            matchDao.insert(match)
        }
    }

    override suspend fun addToFavorite(id: String) {
        matchDao.addToFavorite(id)
    }

    override suspend fun removeFromFavorite(id: String) {
        matchDao.removeFromFavorite(id)
    }

    override suspend fun isFavorite(id: String): Boolean = matchDao.isFavorite(id)

    override suspend fun getFavorites(): List<MatchEntity>? = matchDao.getFavorites()

}
