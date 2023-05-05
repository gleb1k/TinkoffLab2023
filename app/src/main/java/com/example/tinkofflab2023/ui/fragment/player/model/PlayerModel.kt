package com.example.tinkofflab2023.ui.fragment.player.model

import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse

data class PlayerModel(
    val header: PlayerHeaderItem,
    val heroes: PlayerHeroesResponse,
    val recentMatches: PlayerMatchesResponse
)


data class PlayerHeaderItem(
    val playerDataResponse: PlayerDataResponse,
    val playerWL: PlayerWLResponse,
)

fun PlayerModel.toEntity() : PlayerEntity =
    PlayerEntity(
        header.playerDataResponse,
        header.playerWL,
        heroes,
        recentMatches
    )

//
//data class PlayerHeroItem(
//    val playerHeroResponse: PlayerHeroResponse,
////    val heroResponse: HeroResponse
//)
//
//
//data class PlayerRecentMatchItem(
//    val playerRecentMatchResponse: PlayerRecentMatchResponse,
////    val heroResponse: HeroResponse
//)
