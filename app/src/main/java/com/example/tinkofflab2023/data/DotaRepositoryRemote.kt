package com.example.tinkofflab2023.data

import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroesResponse
import com.example.tinkofflab2023.data.remote.response.constants.items.ItemsResponse
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.ui.model.match.MatchOverviewModel
import com.example.tinkofflab2023.ui.model.player.PlayerOverviewModel

class DotaRepositoryRemote(

) : DotaRepository {
    override suspend fun getMatch(matchId: String): MatchResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayerData(accountId: String): PlayerDataResponse {
        TODO("Not yet implemented")
    }

    override suspend fun searchPlayers(name: String): List<SearchPlayerResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayerWL(accountId: String): PlayerWLResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayerRecentMatches(accountId: String): PlayerRecentMatchesResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayerHeroes(accountId: String): PlayerHeroesResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getHeroes(): HeroesResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getItems(): ItemsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun getMatchOverviewModel(matchId: String): MatchOverviewModel {
        TODO("Not yet implemented")
    }

    override suspend fun getPlayerOverviewModel(accountId: String): PlayerOverviewModel {
        TODO("Not yet implemented")
    }
}
