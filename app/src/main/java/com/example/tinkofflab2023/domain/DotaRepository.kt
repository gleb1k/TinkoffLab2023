package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroesResponse
import com.example.tinkofflab2023.data.remote.response.constants.items.ItemsResponse
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.ui.model.match.MatchOverviewModel
import com.example.tinkofflab2023.ui.model.player.PlayerOverviewModel

interface DotaRepository {

    suspend fun getMatch(matchId: String): MatchResponse

    suspend fun getPlayerData(accountId: String): PlayerDataResponse

    suspend fun searchPlayers(name: String): List<SearchPlayerResponse>

    suspend fun getPlayerWL(accountId: String): PlayerWLResponse

    suspend fun getPlayerRecentMatches(accountId: String): PlayerRecentMatchesResponse

    suspend fun getPlayerHeroes(accountId: String): PlayerHeroesResponse

    suspend fun getHeroes(): HeroesResponse

    suspend fun getItems(): ItemsResponse

    suspend fun getMatchOverviewModel(matchId: String): MatchOverviewModel

    suspend fun getPlayerOverviewModel(accountId: String): PlayerOverviewModel

}
