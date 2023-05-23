package com.example.tinkofflab2023.data.remote

import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroesResponse
import com.example.tinkofflab2023.data.remote.response.constants.items.ItemsResponse
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse
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
    ): PlayerMatchesResponse

    @GET("players/{account_id}/matches")
    suspend fun getPlayerMatches(
        @Path("account_id") accountId: String
    ): PlayerMatchesResponse

    @GET("players/{account_id}/heroes")
    suspend fun getPlayerHeroes(
        @Path("account_id") accountId: String
    ): PlayerHeroesResponse
    //endregion

    @GET("constants/items")
    suspend fun getItems(): ItemsResponse

    @GET("constants/heroes")
    suspend fun getHeroes(): HeroesResponse


}
