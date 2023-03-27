package com.example.tinkofflab2023.data

import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse
import com.example.tinkofflab2023.domain.DotaRepository

class DotaRepositoryImpl(
    private val api: DotaApi
) : DotaRepository {

    override suspend fun getMatch(matchId: String): MatchResponse =
        api.getMatch(matchId)

    override suspend fun getPlayerData(accountId: String): PlayerDataResponse =
        api.getPlayerData(accountId)

    override suspend fun searchPlayers(name: String): ArrayList<SearchResponse> =
        api.searchPlayers(name)
}
