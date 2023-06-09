package com.example.tinkofflab2023.data.remote.response.players.heroes


import com.google.gson.annotations.SerializedName

data class PlayerHeroResponse(
    @SerializedName("games")
    val games: Int,
    @SerializedName("hero_id")
    val heroId: Int,
    @SerializedName("last_played")
    val lastPlayed: String,
    @SerializedName("win")
    val win: Int,
)

