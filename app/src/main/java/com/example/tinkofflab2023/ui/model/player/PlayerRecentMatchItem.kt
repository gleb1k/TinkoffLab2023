package com.example.tinkofflab2023.ui.model.player

import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchResponse

data class PlayerRecentMatchItem(
    val playerRecentMatchResponse: PlayerRecentMatchResponse,
    val heroResponse: HeroResponse
)
