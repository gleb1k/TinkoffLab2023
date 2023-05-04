package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.ui.fragment.match.model.MatchModel
import com.example.tinkofflab2023.ui.fragment.player.model.PlayerModel

interface DotaRepository {

//    suspend fun getPlayerData(accountId: String): PlayerDataResponse
//
//    suspend fun getPlayerWL(accountId: String): PlayerWLResponse
//
//    suspend fun getPlayerRecentMatches(accountId: String): PlayerRecentMatchesResponse
//
//    suspend fun getPlayerHeroes(accountId: String): PlayerHeroesResponse

//    suspend fun getHeroes(): HeroesResponse
//
//    suspend fun getItems(): ItemsResponse

    suspend fun getMatchModel(matchId: String): MatchModel

    suspend fun getPlayerModel(accountId: String): PlayerModel
}
