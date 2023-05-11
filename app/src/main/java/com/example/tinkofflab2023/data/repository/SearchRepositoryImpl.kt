package com.example.tinkofflab2023.data.repository

import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.domain.repository.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: DotaApi
) : SearchRepository {

    override suspend fun getMatch(matchId: String): MatchResponse {
        return api.getMatch(matchId)
    }

    override suspend fun searchPlayers(name: String): List<SearchPlayerResponse> =
        api.searchPlayers(name)
}
