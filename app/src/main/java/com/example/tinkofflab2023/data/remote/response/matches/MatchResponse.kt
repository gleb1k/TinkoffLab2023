package com.example.tinkofflab2023.data.remote.response.matches


import com.example.tinkofflab2023.ui.model.MatchItem
import com.example.tinkofflab2023.ui.model.MatchTeamOutcomeItem
import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("barracks_status_dire")
    val barracksStatusDire: Int,
    @SerializedName("barracks_status_radiant")
    val barracksStatusRadiant: Int,
    @SerializedName("cluster")
    val cluster: Int,
    @SerializedName("dire_score")
    val direScore: Int,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("engine")
    val engine: Int,
    @SerializedName("first_blood_time")
    val firstBloodTime: Int,
    @SerializedName("game_mode")
    val gameMode: Int,
    @SerializedName("leagueid")
    val leagueid: Int,
    @SerializedName("lobby_type")
    val lobbyType: Int,
    @SerializedName("match_id")
    val matchId: String,
    @SerializedName("patch")
    val patch: Int,
    @SerializedName("picks_bans")
    val picksBans: List<PicksBan>,
    @SerializedName("players")
    val players: List<Player>,
    @SerializedName("positive_votes")
    val positiveVotes: Int,
    @SerializedName("radiant_score")
    val radiantScore: Int,
    @SerializedName("radiant_win")
    val radiantWin: Boolean,
    @SerializedName("region")
    val region: Int,
    @SerializedName("replay_url")
    val replayUrl: String,
    @SerializedName("start_time")
    val startTime: String,
    @SerializedName("tower_status_dire")
    val towerStatusDire: Int,
    @SerializedName("tower_status_radiant")
    val towerStatusRadiant: Int,
)

fun MatchResponse.getTeamsOutcomes(): List<MatchTeamOutcomeItem> {

    var killsR = 0
    var deathsR = 0
    var assistsR = 0
    var netR = 0

    var killsD = 0
    var deathsD = 0
    var assistsD = 0
    var netD = 0

    players.forEach {
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
        MatchTeamOutcomeItem(true, killsR, deathsR, assistsR, netR),
        MatchTeamOutcomeItem(false, killsD, deathsD, assistsD, netD),
    )
}

fun MatchResponse.toItem(): MatchItem =
    MatchItem(
        barracksStatusDire,
        barracksStatusRadiant,
        cluster,
        direScore,
        duration,
        engine,
        firstBloodTime,
        gameMode,
        leagueid,
        lobbyType,
        matchId,
        patch,
        picksBans,
        positiveVotes,
        radiantScore,
        radiantWin,
        region,
        replayUrl,
        startTime,
        towerStatusDire,
        towerStatusRadiant
    )



