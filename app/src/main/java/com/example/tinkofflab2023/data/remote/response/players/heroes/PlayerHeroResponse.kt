package com.example.tinkofflab2023.data.remote.response.players.heroes


import com.google.gson.annotations.SerializedName

data class PlayerHeroResponse(
    @SerializedName("against_games")
    val againstGames: Int,
    @SerializedName("against_win")
    val againstWin: Int,
    @SerializedName("games")
    val games: Int,
    //todo пришел айди, потом куда с ним идти? из локалки или из сети?
    @SerializedName("hero_id")
    val heroId: String,
    @SerializedName("last_played")
    val lastPlayed: Int,
    @SerializedName("win")
    val win: Int,
    @SerializedName("with_games")
    val withGames: Int,
    @SerializedName("with_win")
    val withWin: Int
)
