package com.example.tinkofflab2023.data.remote.response.players.recentmatches


import com.google.gson.annotations.SerializedName

data class PlayerRecentMatchesResponseItem(
    @SerializedName("assists")
    val assists: Int,
    @SerializedName("average_rank")
    val averageRank: Int,
    @SerializedName("cluster")
    val cluster: Int,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("game_mode")
    val gameMode: Int,
    @SerializedName("gold_per_min")
    val goldPerMin: Int,
    @SerializedName("hero_damage")
    val heroDamage: Int,
    @SerializedName("hero_healing")
    val heroHealing: Int,
    @SerializedName("hero_id")
    val heroId: Int,
    @SerializedName("is_roaming")
    val isRoaming: Any,
    @SerializedName("kills")
    val kills: Int,
    @SerializedName("lane")
    val lane: Any,
    @SerializedName("lane_role")
    val laneRole: Any,
    @SerializedName("last_hits")
    val lastHits: Int,
    @SerializedName("leaver_status")
    val leaverStatus: Int,
    @SerializedName("lobby_type")
    val lobbyType: Int,
    @SerializedName("match_id")
    val matchId: Long,
    @SerializedName("party_size")
    val partySize: Int,
    @SerializedName("player_slot")
    val playerSlot: Int,
    @SerializedName("radiant_win")
    val radiantWin: Boolean,
    @SerializedName("skill")
    val skill: Any,
    @SerializedName("start_time")
    val startTime: Int,
    @SerializedName("tower_damage")
    val towerDamage: Int,
    @SerializedName("version")
    val version: Any,
    @SerializedName("xp_per_min")
    val xpPerMin: Int
)
