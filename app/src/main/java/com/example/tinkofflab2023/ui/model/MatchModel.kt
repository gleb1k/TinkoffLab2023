package com.example.tinkofflab2023.ui.model

import com.example.tinkofflab2023.data.local.entity.HeroEntity
import com.example.tinkofflab2023.data.remote.response.matches.PicksBan
import com.example.tinkofflab2023.data.remote.response.matches.Player

data class MatchModel(
    val matchItem: MatchItem,
    val players: List<MatchPlayerItem>,
    val teamOutcomes: List<MatchTeamOutcomeItem>,
)

data class MatchTeamOutcomeItem(
    val isRadiant: Boolean,
    val summaryKills: Int,
    val summaryDeaths: Int,
    val summaryAssists: Int,
    val summaryNet: Int
)

/*
 *   Player in match, with benchmarks and stats
 */
data class MatchPlayerItem(
    val player: Player,
    val heroEntity: HeroEntity,
)

data class MatchItem(
    val barracksStatusDire: Int,
    val barracksStatusRadiant: Int,
    val cluster: Int?,
    val direScore: Int?,
    val duration: Int,
    val engine: Int?,
    val firstBloodTime: Int?,
    val gameMode: Int?,
    val leagueid: Int?,
    val lobbyType: Int,
    val matchId: String,
    val patch: Int?,
    val picksBans: List<PicksBan>?,
    val positiveVotes: Int?,
    val radiantScore: Int?,
    val radiantWin: Boolean,
    val region: Int?,
    val replayUrl: String?,
    val startTime: String?,
    val towerStatusDire: Int?,
    val towerStatusRadiant: Int?,
)

//todo null safety
fun List<Player>.addHeroes(heroesEntityList: List<HeroEntity>): List<MatchPlayerItem> {
    val playerList = arrayListOf<MatchPlayerItem>()
    forEach { player ->
        playerList.add(
            MatchPlayerItem(
                player,
                heroesEntityList.find { player.heroId == it.id }!!
            )
        )
    }
    return playerList
}
