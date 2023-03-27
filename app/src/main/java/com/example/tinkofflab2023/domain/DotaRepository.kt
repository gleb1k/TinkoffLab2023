package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse

interface DotaRepository {

    suspend fun getMatch(matchId: String ) : MatchResponse

    suspend fun getPlayerData(accountId: String) : PlayerDataResponse

    suspend fun searchPlayers(name : String) : ArrayList<SearchResponse>
}
