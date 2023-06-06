package com.example.tinkofflab2023.ui.model

data class MatchBuildingsState(
    val towerStatusDireNum: Int,
    val towerStatusRadiantNum: Int,
    val barracksStatusDireNum: Int,
    val barracksStatusRadiantNum: Int,
    val radiantWin: Boolean,
    val towerStatusDire: Map<String, String> = mapOf(),
    val towerStatusRadiant: Map<String, String> = mapOf(),
    val barracksStatusDire: Map<String, String> = mapOf(),
    val barracksStatusRadiant: Map<String, String> = mapOf(),
)
