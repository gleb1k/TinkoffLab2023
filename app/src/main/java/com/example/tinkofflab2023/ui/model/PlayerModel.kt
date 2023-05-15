package com.example.tinkofflab2023.ui.model

import com.example.tinkofflab2023.data.local.entity.HeroEntity
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse

data class PlayerModel(
    val header: PlayerHeaderItem,
    val heroes: List<PlayerHeroItem>,
    val recentMatches: List<PlayerMatchItem>,
    val isFavorite: Boolean,
)


data class PlayerHeaderItem(
    val playerDataResponse: PlayerDataResponse,
    val playerWL: PlayerWLResponse,
)

/*
    Hero in player account, with hero entity
 */
data class PlayerHeroItem(
    var heroResponse: PlayerHeroResponse,
    val heroEntity: HeroEntity,
)

data class PlayerMatchItem(
    val matchResponse: PlayerMatchResponse,
    val heroEntity: HeroEntity,
)


