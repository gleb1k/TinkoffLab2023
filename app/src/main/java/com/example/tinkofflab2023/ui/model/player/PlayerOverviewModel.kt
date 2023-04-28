package com.example.tinkofflab2023.ui.model.player

data class PlayerOverviewModel(
    val header: PlayerHeaderItem,
    val heroes: List<PlayerHeroItem>,
    val recentMatches: List<PlayerRecentMatchItem>
)
