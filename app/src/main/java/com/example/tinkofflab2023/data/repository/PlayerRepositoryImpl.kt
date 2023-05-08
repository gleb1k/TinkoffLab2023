package com.example.tinkofflab2023.data.repository

import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse
import com.example.tinkofflab2023.domain.PlayerRepository

class PlayerRepositoryImpl(
    private val db: AppDatabase,
    private val api: DotaApi
) : PlayerRepository {

    private val playerDao = db.getPlayerDao()

    // Если в бд нет, иду в сеть, если в сети нет -> возвращаю null
    override suspend fun getEntity(accountId: String): PlayerEntity? {
        playerDao.get(accountId)?.let {
            return it
        }
        try {
            return PlayerEntity(
                playerData = api.getPlayerData(accountId),
                heroes = api.getPlayerHeroes(accountId),
                recentMatches = api.getPlayerRecentMatches(accountId),
                wl = api.getPlayerWL(accountId),
            ).also {
                playerDao.insert(it)
            }
        } catch (throwable: Throwable) {
            return null
        }
    }

    /*
    Если нет интернета то возвращаю только недавние матчи
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
}




//    override fun getPlayerEntity(accountId: String): Flow<Resource<PlayerEntity>> =
//        networkBoundResource(
//            accountId,
//            query = {
//                playerDao.get(accountId)
//            },
//            fetch = {
//                PlayerEntity(
//                    playerData = api.getPlayerData(accountId),
//                    heroes = api.getPlayerHeroes(accountId),
//                    recentMatches = api.getPlayerRecentMatches(accountId),
//                    wl = api.getPlayerWL(accountId),
//                )
//            },
//            saveFetchResult = { player ->
//                db.withTransaction {
//                    playerDao.deleteById(accountId)
//                    playerDao.save(player)
//                }
//            }
//        )

