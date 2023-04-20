package com.example.tinkofflab2023.data

import com.example.tinkofflab2023.ui.model.match.TeamOutcome
import com.example.tinkofflab2023.ui.model.match.TeamPlayer
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroesResponse
import com.example.tinkofflab2023.data.remote.response.constants.items.ItemsResponse
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchResponse
import com.example.tinkofflab2023.domain.DotaRepository

class DotaRepositoryImpl(
    private val api: DotaApi
) : DotaRepository {

    override suspend fun getMatch(matchId: String): MatchResponse =
        api.getMatch(matchId)

    override suspend fun searchPlayers(name: String): List<SearchResponse> =
        api.searchPlayers(name)

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

    //todo СУПЕР ВАЖНО. Возвращение правильного типа для ячейки рекуклера. Тоесть нужно наколхозить нечто такое?
    //HeroItemData будет содержать данные о всех персонажах и данные о топ персонажах для игрока
//    suspend fun getPlayerHeroItemData(accountId: String) : HeroItemData {
//       return api.getPlayerHeroes(accountId) + api.getHeroes()
//    }

    override suspend fun getTeamsPlayers(matchId: String): List<TeamPlayer> {
        val matchResponse = getMatch(matchId)
        val heroesResponse = getHeroes()

        val teamPlayers = ArrayList<TeamPlayer>(10)
        matchResponse.players.forEach {
            teamPlayers +=
                TeamPlayer(
                    playerSlot = it.playerSlot,
                    name = it.personaname?: "Закрытый профиль",
                    kills = it.kills,
                    assists = it.assists,
                    deaths = it.deaths,
                    net = it.netWorth,
                    heroId = it.heroId,
                    heroImg = ""
//                    heroImg = heroesResponse.first
//                    { heroResponse -> it.heroId == heroResponse.id }.img
                )
        }
        return teamPlayers
    }

    //NASRAL
    override suspend fun getTeamsOutcomes(matchId: String): List<TeamOutcome> {
        val matchResponse = getMatch(matchId)

        var killsR = 0
        var deathsR = 0
        var assistsR = 0
        var netR = 0

        var killsD = 0
        var deathsD = 0
        var assistsD = 0
        var netD = 0

        matchResponse.players.forEach {
            if (it.isRadiant) {
                killsR += it.kills
                deathsR += it.deaths
                assistsR += it.assists
                netR += it.netWorth
            } else {
                killsD += it.kills
                deathsD += it.deaths
                assistsD += it.assists
                netD += it.netWorth
            }
        }
        return listOf(
            TeamOutcome(true, killsR, deathsR, assistsR, netR),
            TeamOutcome(false, killsD, deathsD, assistsD, netD),
        )
    }
}
