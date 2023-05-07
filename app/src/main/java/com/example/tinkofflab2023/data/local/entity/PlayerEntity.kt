package com.example.tinkofflab2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tinkofflab2023.data.local.converter.PlayerConverter
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse

@Entity(tableName = "players")
@TypeConverters(PlayerConverter::class)
data class PlayerEntity(
    val playerData: PlayerDataResponse,
    val wl: PlayerWLResponse,
    val heroes: PlayerHeroesResponse,
    val recentMatches: PlayerMatchesResponse,

    @PrimaryKey
    val id: String = playerData.profile.accountId,
)
//
//fun PlayerEntity.toModel(): PlayerModel =
//    PlayerModel(
//        PlayerHeaderItem(playerData, wl),
//        heroes,
//        recentMatches
//    )
