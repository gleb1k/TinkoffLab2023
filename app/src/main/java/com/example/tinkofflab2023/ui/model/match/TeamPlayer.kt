package com.example.tinkofflab2023.ui.model.match

data class TeamPlayer(
    val playerSlot : Int,
    val name: String?,
    val kills: Int,
    val deaths: Int,
    val assists: Int,
    val net: Int,
    val heroId: Int,
    val heroImg: String,
)
