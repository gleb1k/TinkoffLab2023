package com.example.tinkofflab2023.ui.fragment.player.model

data class PlayerModel(
    val header: PlayerHeaderItem,
    val heroes: List<PlayerHeroItem>,
    val recentMatches: List<PlayerRecentMatchItem>
)
