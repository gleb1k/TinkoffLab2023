package com.example.tinkofflab2023.data.repository

import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.entity.toModel
import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.ui.fragment.match.model.MatchModel
import com.example.tinkofflab2023.ui.fragment.player.model.PlayerModel
import com.example.tinkofflab2023.ui.fragment.player.model.toEntity

class DotaRepositoryLocal(
    private val db: AppDatabase
) : DotaRepository {

    private val playerDao by lazy {
        db.getPlayerDao()
    }

    private val matchDao by lazy {
        db.getMatchDao()
    }

    suspend fun savePlayer(player: PlayerModel) {
        playerDao.save(player.toEntity())
    }

    override suspend fun getMatchModel(matchId: String): MatchModel {
        return matchDao.get(matchId).toModel()
    }

    override suspend fun getPlayerModel(accountId: String): PlayerModel {
        return playerDao.get(accountId).toModel()
    }
}
