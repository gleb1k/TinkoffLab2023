package com.example.tinkofflab2023.data.repository

import androidx.room.withTransaction
import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.clearNeverPlayedHeroes
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse
import com.example.tinkofflab2023.domain.repository.PlayerRepository
import javax.inject.Inject

class PlayerRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val api: DotaApi
) : PlayerRepository {

    private val playerDao = db.getPlayerDao()

    private suspend fun getApiEntity(accountId: String, isFavorite : Boolean = false): PlayerEntity = PlayerEntity(
        playerData = api.getPlayerData(accountId),
        heroes = api.getPlayerHeroes(accountId).clearNeverPlayedHeroes(),
        recentMatches = api.getPlayerRecentMatches(accountId),
        wl = api.getPlayerWL(accountId),
        isFavorite = isFavorite
    )

    //todo nasral!!!!!!!!!!
    // Если в бд нет, иду в сеть, если в сети нет -> возвращаю null
    override suspend fun getEntity(id: String): PlayerEntity? {
        playerDao.get(id)?.let {
            return it
        }
        try {
            return getApiEntity(id).also {
                addToCache(it)
            }
            //todo
            //runCatching {}
//            val result = Result<PlayerEntity>
        } catch (throwable: Throwable) {
            return null
        }
    }

    /**
     *  If cache entities is more than 3 -> delete them all
     */
    private suspend fun addToCache(player: PlayerEntity) {
        if (playerDao.countCache() >= 3) {
            db.withTransaction {
                playerDao.clearCache()
                playerDao.insert(player)
            }
        } else {
            playerDao.insert(player)
        }
    }

    /**
     *  If there is no Network connection returns only recent matches
     */
    //todo get() -> getMatches()
    override suspend fun getMatches(id: String): PlayerMatchesResponse? {
        return try {
            api.getPlayerMatches(id)
        } catch (throwable: Throwable) {
            playerDao.get(id)?.recentMatches
        }
    }


    //todo get() -> getHeroes()
    override suspend fun getHeroes(id: String): PlayerHeroesResponse? {
        playerDao.get(id)?.let {
            return it.heroes
        }
        return try {
            api.getPlayerHeroes(id)
        } catch (throwable: Throwable) {
            null
        }
    }

    override suspend fun addToFavorite(id: String) {
        playerDao.addToFavorite(id)
    }

    override suspend fun removeFromFavorite(id: String) {
        playerDao.removeFromFavorite(id)
    }

    override suspend fun isFavorite(id: String): Boolean = playerDao.isFavorite(id) ?: false

    override suspend fun getFavorites(): List<PlayerEntity>? = playerDao.getFavorites()

    // Иду в сразу в сеть -> потом перезаписываю в бд
    override suspend fun refresh(id: String)  {
        try {
            val isFavorite = isFavorite(id)
            getApiEntity(id, isFavorite).also {
                playerDao.insert(it)
            }
        } catch (_: Throwable) {
        }
    }
}
