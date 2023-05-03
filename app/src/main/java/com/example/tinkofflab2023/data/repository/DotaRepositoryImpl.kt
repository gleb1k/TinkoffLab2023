package com.example.tinkofflab2023.data.repository

//class DotaRepositoryImpl(
//    private val api: DotaApi
//) : DotaRepository {
//
//    override suspend fun getMatch(matchId: String): MatchResponse {
//        return api.getMatch(matchId)
//    }
//
//    override suspend fun searchPlayers(name: String): List<SearchPlayerResponse> =
//        api.searchPlayers(name).subList(0, 24)
//
//    override suspend fun getPlayerData(accountId: String): PlayerDataResponse =
//        api.getPlayerData(accountId)
//
//    override suspend fun getPlayerWL(accountId: String): PlayerWLResponse =
//        api.getPlayerWL(accountId)
//
//    override suspend fun getPlayerRecentMatches(accountId: String): PlayerRecentMatchesResponse =
//        api.getPlayerRecentMatches(accountId)
//
//    override suspend fun getPlayerHeroes(accountId: String): PlayerHeroesResponse =
//        api.getPlayerHeroes(accountId)
//
//    override suspend fun getHeroes(): HeroesResponse =
//        api.getHeroes()
//
//    override suspend fun getItems(): ItemsResponse =
//        api.getItems()
//
//    //region match
//    override suspend fun getMatchModel(matchId: String): MatchModel {
//        val heroes = getHeroes()
//        val match = getMatch(matchId)
//
//        return MatchModel(
//            matchResponse = match,
//            players = getMatchPlayersWithHeroes(match, heroes),
//            teamOutcomes = match.getTeamsOutcomes()
//        )
//    }
//
//    private fun getMatchPlayersWithHeroes(
//        match: MatchResponse,
//        heroes: HeroesResponse
//    ): List<MatchPlayerHeroItem> {
//        val matchPlayersHeroes = ArrayList<MatchPlayerHeroItem>()
//
//        match.players.forEach {
//            matchPlayersHeroes += MatchPlayerHeroItem(
//                player = it,
//                heroResponse = heroes[it.heroId.toString()]!!,
//            )
//        }
//        return matchPlayersHeroes
//    }
//    //endregion
//
//    override suspend fun getPlayerModel(accountId: String): PlayerModel {
//        val heroes = getHeroes()
//
//        return PlayerModel(
//            header = getPlayerHeaderItem(accountId),
//            heroes = getPlayerHeroesItems(accountId, heroes),
//            recentMatches = getPlayerRecentMatchesItems(accountId, heroes),
//        )
//    }
//
//    private suspend fun getPlayerHeaderItem(accountId: String): PlayerHeaderItem =
//        PlayerHeaderItem(
//            playerDataResponse = getPlayerData(accountId),
//            playerWL = getPlayerWL(accountId)
//        )
//
//    private suspend fun getPlayerHeroesItems(
//        accountId: String,
//        heroes: HeroesResponse
//    ): List<PlayerHeroItem> {
//        val playerHeroes = getPlayerHeroes(accountId)
//
//        val listHeroes = ArrayList<PlayerHeroItem>()
//
//        playerHeroes.forEach {
//            listHeroes += PlayerHeroItem(
//                it,
//                heroes[it.heroId]!!
//            )
//        }
//        return listHeroes
//    }
//
//    private suspend fun getPlayerRecentMatchesItems(
//        accountId: String,
//        heroes: HeroesResponse
//    ): List<PlayerRecentMatchItem> {
//        val playerRecentMatchesResponse = getPlayerRecentMatches(accountId)
//
//        val listMatches = ArrayList<PlayerRecentMatchItem>()
//
//        playerRecentMatchesResponse.forEach {
//            listMatches += PlayerRecentMatchItem(
//                it,
//                heroes[it.heroId]!!
//            )
//        }
//        return listMatches
//    }
//}
