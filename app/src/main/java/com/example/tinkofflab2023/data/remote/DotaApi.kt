package com.example.tinkofflab2023.data.remote

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
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

    //todo что лучше возвращать?
    @GET("search")
    suspend fun searchPlayers(
        @Query("q") name : String
    ) : ArrayList<SearchResponse>

}
