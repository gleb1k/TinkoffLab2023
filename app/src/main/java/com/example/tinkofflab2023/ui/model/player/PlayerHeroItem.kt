package com.example.tinkofflab2023.ui.model.player

import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroResponse

data class PlayerHeroItem(
    val playerHeroResponse: PlayerHeroResponse,
    val heroResponse: HeroResponse
    )
