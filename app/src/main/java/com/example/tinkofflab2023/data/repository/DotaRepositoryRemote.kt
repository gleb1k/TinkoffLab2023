package com.example.tinkofflab2023.data.repository

import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.domain.DotaRepository

class DotaRepositoryRemote(
    private val api: DotaApi
) : DotaRepository {

    override suspend fun getMatchEntity(matchId: String): MatchEntity? {
        return try {
            MatchEntity(
                matchResponse = getMatch(matchId),
            )
        } catch (ex: Throwable) {
            null
        }
    }

    override suspend fun getPlayerEntity(accountId: String): PlayerEntity? {
        return try {
            PlayerEntity(
                playerData = getPlayerData(accountId),
                heroes = getPlayerHeroes(accountId),
                recentMatches = getPlayerRecentMatches(accountId),
                wl = getPlayerWL(accountId),
            )
        } catch (ex: Throwable) {
            null
        }
    }

    private suspend fun getMatch(matchId: String): MatchResponse {
        return api.getMatch(matchId)
    }

    private suspend fun getPlayerData(accountId: String): PlayerDataResponse =
        api.getPlayerData(accountId)

    private suspend fun getPlayerWL(accountId: String): PlayerWLResponse =
        api.getPlayerWL(accountId)

    private suspend fun getPlayerRecentMatches(accountId: String): PlayerMatchesResponse =
        api.getPlayerRecentMatches(accountId)

    private suspend fun getPlayerHeroes(accountId: String): PlayerHeroesResponse =
        api.getPlayerHeroes(accountId)

}
