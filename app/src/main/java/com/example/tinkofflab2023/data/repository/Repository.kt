package com.example.tinkofflab2023.data.repository

import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.ui.fragment.match.model.MatchModel
import com.example.tinkofflab2023.ui.fragment.player.model.PlayerModel

class Repository(
    private val repositoryLocal: DotaRepositoryLocal,
    private val repositoryRemote: DotaRepositoryRemote
) : DotaRepository {

    override suspend fun getMatchModel(matchId: String): MatchModel {
        try {
            return repositoryLocal.getMatchModel(matchId)
        } catch (ex: Throwable) {
            return repositoryRemote.getMatchModel(matchId)
        }
    }

    override suspend fun getPlayerModel(accountId: String): PlayerModel {
        try {
            return repositoryLocal.getPlayerModel(accountId)
        } catch (ex: Throwable) {
            return repositoryRemote.getPlayerModel(accountId).also {
                repositoryLocal.savePlayer(it)
            }
        }
    }

}
