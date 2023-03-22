package com.example.tinkofflab2023.data.remote

import com.example.tinkofflab2023.data.remote.response.match.MatchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DotaApi {

    @GET("/match/{match_id}")
    suspend fun getMatch(
        @Path("match_id") matchId: String
    ) : MatchResponse

}
