package com.example.tinkofflab2023.ui.fragment.match.model

import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroResponse
import com.example.tinkofflab2023.data.remote.response.matches.Player

data class MatchPlayerHeroItem(
    val player: Player,
    val heroResponse: HeroResponse
)
