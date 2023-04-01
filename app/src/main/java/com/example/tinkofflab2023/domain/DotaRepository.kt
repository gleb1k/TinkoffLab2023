package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse

interface DotaRepository {

    suspend fun getMatch(matchId: String): MatchResponse

    suspend fun getPlayerData(accountId: String): PlayerDataResponse

    suspend fun searchPlayers(name: String): List<SearchResponse>

    suspend fun getPlayerWL(accountId: String): PlayerWLResponse

    suspend fun getPlayerRecentMatches(accountId: String): PlayerRecentMatchesResponse

    suspend fun getPlayerHeroes(accountId: String): PlayerHeroesResponse
}
