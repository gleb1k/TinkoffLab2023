package com.example.tinkofflab2023.data

import com.example.tinkofflab2023.data.remote.DotaApi
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
import com.example.tinkofflab2023.ui.model.match.MatchPlayerHeroItem
import com.example.tinkofflab2023.ui.model.player.PlayerHeaderItem
import com.example.tinkofflab2023.ui.model.player.PlayerHeroItem
import com.example.tinkofflab2023.ui.model.player.PlayerOverviewModel
import com.example.tinkofflab2023.ui.model.player.PlayerRecentMatchItem
import com.example.tinkofflab2023.utils.getTeamsOutcomes

class DotaRepositoryImpl(
    private val api: DotaApi
) : DotaRepository {

    override suspend fun getMatch(matchId: String): MatchResponse {
        return api.getMatch(matchId)
    }

    override suspend fun searchPlayers(name: String): List<SearchPlayerResponse> =
        api.searchPlayers(name).subList(0, 24)

    override suspend fun getPlayerData(accountId: String): PlayerDataResponse =
        api.getPlayerData(accountId)

    override suspend fun getPlayerWL(accountId: String): PlayerWLResponse =
        api.getPlayerWL(accountId)

    override suspend fun getPlayerRecentMatches(accountId: String): PlayerRecentMatchesResponse =
        api.getPlayerRecentMatches(accountId)

    override suspend fun getPlayerHeroes(accountId: String): PlayerHeroesResponse =
        api.getPlayerHeroes(accountId)

    override suspend fun getHeroes(): HeroesResponse =
        api.getHeroes()

    override suspend fun getItems(): ItemsResponse =
        api.getItems()

    //region match
    override suspend fun getMatchOverviewModel(matchId: String): MatchOverviewModel {
        val heroes = getHeroes()
        val match = getMatch(matchId)

        return MatchOverviewModel(
            matchResponse = match,
            players = getMatchPlayersWithHeroes(match, heroes),
            teamOutcomes = match.getTeamsOutcomes()
        )
    }

    private fun getMatchPlayersWithHeroes(
        match: MatchResponse,
        heroes: HeroesResponse
    ): List<MatchPlayerHeroItem> {
        val matchPlayersHeroes = ArrayList<MatchPlayerHeroItem>()

        match.players.forEach {
            matchPlayersHeroes += MatchPlayerHeroItem(
                player = it,
                heroResponse = heroes[it.heroId.toString()]!!,
            )
        }
        return matchPlayersHeroes
    }
    //endregion

    override suspend fun getPlayerOverviewModel(accountId: String): PlayerOverviewModel {
        val heroes = getHeroes()

        return PlayerOverviewModel(
            header = getPlayerHeaderItem(accountId),
            heroes = getPlayerHeroesItems(accountId, heroes),
            recentMatches = getPlayerRecentMatchesItems(accountId, heroes),
        )
    }

    private suspend fun getPlayerHeaderItem(accountId: String): PlayerHeaderItem =
        PlayerHeaderItem(
            playerDataResponse = getPlayerData(accountId),
            playerWL = getPlayerWL(accountId)
        )

    private suspend fun getPlayerHeroesItems(
        accountId: String,
        heroes: HeroesResponse
    ): List<PlayerHeroItem> {
        val playerHeroes = getPlayerHeroes(accountId)

        val listHeroes = ArrayList<PlayerHeroItem>()

        playerHeroes.forEach {
            listHeroes += PlayerHeroItem(
                it,
                heroes[it.heroId]!!
            )
        }
        return listHeroes
    }

    private suspend fun getPlayerRecentMatchesItems(
        accountId: String,
        heroes: HeroesResponse
    ): List<PlayerRecentMatchItem> {
        val playerRecentMatchesResponse = getPlayerRecentMatches(accountId)

        val listMatches = ArrayList<PlayerRecentMatchItem>()

        playerRecentMatchesResponse.forEach {
            listMatches += PlayerRecentMatchItem(
                it,
                heroes[it.heroId]!!
            )
        }
        return listMatches
    }
}
