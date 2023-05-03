package com.example.tinkofflab2023.domain

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse

interface SearchRepository {

    suspend fun getMatch(matchId: String): MatchResponse

    suspend fun searchPlayers(name: String): List<SearchPlayerResponse>
}
