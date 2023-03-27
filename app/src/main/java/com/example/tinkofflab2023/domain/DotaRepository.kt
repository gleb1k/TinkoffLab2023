package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse

interface DotaRepository {

    suspend fun getMatch(matchId: String ) : MatchResponse
}
