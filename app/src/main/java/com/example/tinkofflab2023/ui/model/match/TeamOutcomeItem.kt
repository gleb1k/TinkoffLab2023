package com.example.tinkofflab2023.ui.model.match

data class TeamOutcomeItem(
    val isRadiant: Boolean,
    val summaryKills: Int,
    val summaryDeaths: Int,
    val summaryAssists: Int,
    val summaryNet: Int
)
