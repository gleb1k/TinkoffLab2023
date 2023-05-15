package com.example.tinkofflab2023.data.remote

import com.example.tinkofflab2023.data.remote.response.constants.HeroResponse
import com.example.tinkofflab2023.data.remote.response.constants.ItemResponse
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DotaApi {

    @GET("search")
    suspend fun searchPlayers(
        @Query("q") name: String
    ): List<SearchPlayerResponse>

    @GET("matches/{match_id}")
    suspend fun getMatch(
        @Path("match_id") matchId: String
    ): MatchResponse

    //region players
    @GET("players/{account_id}")
    suspend fun getPlayerData(
        @Path("account_id") accountId: String
    ): PlayerDataResponse

    @GET("players/{account_id}/wl")
    suspend fun getPlayerWL(
        @Path("account_id") accountId: String
    ): PlayerWLResponse

    @GET("players/{account_id}/recentMatches")
    suspend fun getPlayerRecentMatches(
        @Path("account_id") accountId: String
    ): List<PlayerMatchResponse>

    @GET("players/{account_id}/matches")
    suspend fun getPlayerMatches(
        @Path("account_id") accountId: String
    ): List<PlayerMatchResponse>

    @GET("players/{account_id}/heroes")
    suspend fun getPlayerHeroes(
        @Path("account_id") accountId: String
    ): List<PlayerHeroResponse>
    //endregion

    @GET("constants/items")
    suspend fun getItems(): HashMap<String, ItemResponse>

    @GET("constants/heroes")
    suspend fun getHeroes(): HashMap<String, HeroResponse>

}
