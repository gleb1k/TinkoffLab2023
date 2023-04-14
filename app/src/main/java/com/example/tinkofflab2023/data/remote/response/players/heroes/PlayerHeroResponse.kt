package com.example.tinkofflab2023.data.remote.response.players.heroes


import com.google.gson.annotations.SerializedName

data class PlayerHeroResponse(
    @SerializedName("games")
    val games: Int,
    @SerializedName("hero_id")
    val heroId: String,
    @SerializedName("last_played")
    val lastPlayed: Int,
    @SerializedName("win")
    val win: Int,
)
