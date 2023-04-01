package com.example.tinkofflab2023.data.remote

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DotaApi {

    @GET("matches/{match_id}")
    suspend fun getMatch(
        @Path("match_id") matchId: String
    ) : MatchResponse

    @GET("players/{account_id}")
    suspend fun getPlayerData(
        @Path("account_id") accountId: String
    ) : PlayerDataResponse

    //мин символов для поиска == 3, если меньше, то приходит пустой список
    @GET("search")
    suspend fun searchPlayers(
        @Query("q") name : String
    ) : List<SearchResponse>

    @GET("players/{account_id}/wl")
    suspend fun getPlayerWL(
        @Path("account_id") accountId: String
    ): PlayerWLResponse

    @GET("players/{account_id}/recentMatches")
    suspend fun getPlayerRecentMatches(
        @Path("account_id") accountId: String
    ): PlayerRecentMatchesResponse

    @GET("players/{account_id}/heroes")
    suspend fun getPlayerHeroes(
        @Path("account_id") accountId: String
    ): PlayerHeroesResponse
}
