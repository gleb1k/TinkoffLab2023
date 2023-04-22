package com.example.tinkofflab2023.ui.model.player

import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchResponse
import com.example.tinkofflab2023.databinding.FragmentPlayerMatchesBinding

data class PlayerOverviewModel(
    val playerDataResponse: PlayerDataResponse,
    val playerHeroesResponse: HeroesResponse,
    val playerRecentMatchResponse: PlayerRecentMatchResponse,
)
