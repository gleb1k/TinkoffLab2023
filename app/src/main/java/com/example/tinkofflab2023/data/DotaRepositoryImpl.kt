package com.example.tinkofflab2023.data

import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.match.MatchResponse
import com.example.tinkofflab2023.domain.DotaRepository

class DotaRepositoryImpl(
    private val api: DotaApi
): DotaRepository {
    override suspend fun getMatch(matchId: String): MatchResponse = api.getMatch(matchId)

}
