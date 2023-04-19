package com.example.tinkofflab2023.data.model

data class TeamPlayer(
    val accountId : String,
    val name: String,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val net: Int,
    val heroId: Int,
    val heroImg: String,
)
