package com.example.tinkofflab2023.data.repository

import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.matches.getTeamsOutcomes
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.domain.DotaRepository
import com.example.tinkofflab2023.ui.fragment.match.model.MatchModel
import com.example.tinkofflab2023.ui.fragment.player.model.PlayerHeaderItem
import com.example.tinkofflab2023.ui.fragment.player.model.PlayerModel

class DotaRepositoryRemote(
    private val api: DotaApi
) : DotaRepository {

    override suspend fun getMatchModel(matchId: String): MatchModel {
        val match = getMatch(matchId)

        return MatchModel(
            matchResponse = match,
            teamOutcomes = match.getTeamsOutcomes()
        )
    }

    override suspend fun getPlayerModel(accountId: String): PlayerModel =
        PlayerModel(
            header = getPlayerHeaderItem(accountId),
            heroes = getPlayerHeroes(accountId),
            recentMatches = getPlayerRecentMatches(accountId),
        )


    private suspend fun getPlayerHeaderItem(accountId: String): PlayerHeaderItem =
        PlayerHeaderItem(
            playerDataResponse = getPlayerData(accountId),
            playerWL = getPlayerWL(accountId)
        )

    //    private fun getMatchPlayersWithHeroes(
//        match: MatchResponse,
//    ): List<MatchPlayerHeroItem> {
//        val matchPlayersHeroes = ArrayList<MatchPlayerHeroItem>()
//
//        match.players.forEach {
//            matchPlayersHeroes += MatchPlayerHeroItem(
//                player = it,
//            )
//        }
//        return matchPlayersHeroes
//    }

    //    private suspend fun getPlayerHeroesItems(
//        accountId: String,
//    ): List<PlayerHeroItem> {
//        val playerHeroes = getPlayerHeroes(accountId)
//
//        val listHeroes = ArrayList<PlayerHeroItem>()
//
//        playerHeroes.forEach {
//            listHeroes += PlayerHeroItem(
//                it,
//            )
//        }
//        return listHeroes
//    }
//
//    private suspend fun getPlayerRecentMatchesItems(
//        accountId: String,
//    ): List<PlayerRecentMatchItem> {
//        val playerRecentMatchesResponse = getPlayerRecentMatches(accountId)
//
//        val listMatches = ArrayList<PlayerRecentMatchItem>()
//
//        playerRecentMatchesResponse.forEach {
//            listMatches += PlayerRecentMatchItem(
//                it,
//            )
//        }
//        return listMatches
//    }
    private suspend fun getMatch(matchId: String): MatchResponse {
        return api.getMatch(matchId)
    }

    private suspend fun getPlayerData(accountId: String): PlayerDataResponse =
        api.getPlayerData(accountId)

    private suspend fun getPlayerWL(accountId: String): PlayerWLResponse =
        api.getPlayerWL(accountId)

    private suspend fun getPlayerRecentMatches(accountId: String): PlayerRecentMatchesResponse =
        api.getPlayerRecentMatches(accountId)

    private suspend fun getPlayerHeroes(accountId: String): PlayerHeroesResponse =
        api.getPlayerHeroes(accountId)

}
