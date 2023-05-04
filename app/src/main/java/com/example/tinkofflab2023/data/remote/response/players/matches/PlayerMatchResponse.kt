package com.example.tinkofflab2023.data.remote.response.players.matches


import com.google.gson.annotations.SerializedName

data class PlayerMatchResponse(
    @SerializedName("assists")
    val assists: Int,
    @SerializedName("average_rank")
    val averageRank: Int,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("game_mode")
    val gameMode: Int,
    @SerializedName("hero_id")
    val heroId: String,
    @SerializedName("kills")
    val kills: Int,
    @SerializedName("lobby_type")
    val lobbyType: Int,
    @SerializedName("match_id")
    val matchId: String,
    @SerializedName("party_size")
    val partySize: Int,
    @SerializedName("player_slot")
    val playerSlot: Int,
    @SerializedName("radiant_win")
    val radiantWin: Boolean,
    @SerializedName("start_time")
    val startTime: String,
)
