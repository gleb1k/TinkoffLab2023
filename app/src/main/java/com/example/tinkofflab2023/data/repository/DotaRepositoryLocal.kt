package com.example.tinkofflab2023.data.repository

import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.domain.DotaRepository

//class DotaRepositoryLocal(
//    private val db: AppDatabase
//) : DotaRepository {
//
//    private val playerDao by lazy {
//        db.getPlayerDao()
//    }
//
//    private val matchDao by lazy {
//        db.getMatchDao()
//    }
//
//    suspend fun savePlayer(player: PlayerEntity) {
//        playerDao.save(player)
//    }
//
//    override suspend fun getMatchEntity(matchId: String): MatchEntity? {
//        return matchDao.get(matchId)
//    }
//
//    override suspend fun getPlayerEntity(accountId: String): PlayerEntity? {
//        return playerDao.get(accountId)
//    }
//}
