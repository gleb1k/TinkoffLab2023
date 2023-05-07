package com.example.tinkofflab2023.data.repository

import androidx.room.withTransaction
import com.example.tinkofflab2023.core.util.Resource
import com.example.tinkofflab2023.core.util.networkBoundResource
import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.domain.DotaRepository
import kotlinx.coroutines.flow.Flow

class DotaRepositoryImpl(
//    private val repositoryLocal: DotaRepositoryLocal,
//    private val repositoryRemote: DotaRepositoryRemote
    private val db: AppDatabase,
    private val api: DotaApi
) : DotaRepository {

    private val playerDao = db.getPlayerDao()

    private val matchDao = db.getMatchDao()

    override suspend fun getMatchEntity(matchId: String): MatchEntity? {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayerEntity(accountId: String): PlayerEntity? {
        TODO("Not yet implemented")
    }

    fun getPlayer(accountId: String) : Flow<Resource<PlayerEntity>> = networkBoundResource(
        accountId,
        query = {
            playerDao.get(accountId)
        },
        fetch = {
            PlayerEntity(
                playerData = api.getPlayerData(accountId),
                heroes = api.getPlayerHeroes(accountId),
                recentMatches = api.getPlayerRecentMatches(accountId),
                wl = api.getPlayerWL(accountId),
            )
        },
        saveFetchResult = { player ->
            db.withTransaction {
                playerDao.deleteById(accountId)
                playerDao.save(player)
            }
        }
    )

//    override suspend fun getMatchEntity(matchId: String): MatchEntity? {
////        try {
////            return repositoryLocal.getMatchEntity(matchId)
////        } catch (ex: Throwable) {
////            return repositoryRemote.getMatchEntity(matchId)
////        }
//        if (repositoryLocal.getMatchEntity(matchId))
//    }
//
//    override suspend fun getPlayerEntity(accountId: String): PlayerEntity? {
//        try {
//            return repositoryLocal.getPlayerEntity(accountId)
//        } catch (ex: Throwable) {
//            return repositoryRemote.getPlayerEntity(accountId).also {
//                repositoryLocal.savePlayer(it)
//            }
//        }
//    }

}
