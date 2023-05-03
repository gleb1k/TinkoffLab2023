package com.example.tinkofflab2023.data.remote.response.matches


import com.example.tinkofflab2023.ui.fragment.match.model.TeamOutcomeItem
import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("barracks_status_dire")
    val barracksStatusDire: Int,
    @SerializedName("barracks_status_radiant")
    val barracksStatusRadiant: Int,
    @SerializedName("chat")
    val chat: Any,
    @SerializedName("cluster")
    val cluster: Int,
    @SerializedName("cosmetics")
    val cosmetics: Any,
    @SerializedName("dire_score")
    val direScore: Int,
    @SerializedName("dire_team_id")
    val direTeamId: Any,
    @SerializedName("draft_timings")
    val draftTimings: Any,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("engine")
    val engine: Int,
    @SerializedName("first_blood_time")
    val firstBloodTime: Int,
    @SerializedName("game_mode")
    val gameMode: Int,
    @SerializedName("human_players")
    val humanPlayers: Int,
    @SerializedName("leagueid")
    val leagueid: Int,
    @SerializedName("lobby_type")
    val lobbyType: Int,
    @SerializedName("match_id")
    val matchId: String,
    @SerializedName("negative_votes")
    val negativeVotes: Int,
    @SerializedName("objectives")
    val objectives: Any,
    @SerializedName("patch")
    val patch: Int,
    @SerializedName("picks_bans")
    val picksBans: List<PicksBan>,
    @SerializedName("players")
    val players: List<Player>,
    @SerializedName("positive_votes")
    val positiveVotes: Int,
    @SerializedName("radiant_gold_adv")
    val radiantGoldAdv: Any,
    @SerializedName("radiant_score")
    val radiantScore: Int,
    @SerializedName("radiant_team_id")
    val radiantTeamId: Any,
    @SerializedName("radiant_win")
    val radiantWin: Boolean,
    @SerializedName("radiant_xp_adv")
    val radiantXpAdv: Any,
    @SerializedName("region")
    val region: Int,
    @SerializedName("replay_salt")
    val replaySalt: Int,
    @SerializedName("replay_url")
    val replayUrl: String,
    @SerializedName("series_id")
    val seriesId: Int,
    @SerializedName("series_type")
    val seriesType: Int,
    @SerializedName("skill")
    val skill: Any,
    @SerializedName("start_time")
    val startTime: String,
    @SerializedName("teamfights")
    val teamfights: Any,
    @SerializedName("tower_status_dire")
    val towerStatusDire: Int,
    @SerializedName("tower_status_radiant")
    val towerStatusRadiant: Int,
    @SerializedName("version")
    val version: Any
)

fun MatchResponse.getTeamsOutcomes(): List<TeamOutcomeItem> {

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
        TeamOutcomeItem(true, killsR, deathsR, assistsR, netR),
        TeamOutcomeItem(false, killsD, deathsD, assistsD, netD),
    )
}


