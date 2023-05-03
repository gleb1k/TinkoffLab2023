package com.example.tinkofflab2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.recentmatches.PlayerRecentMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.ui.fragment.player.model.PlayerHeaderItem
import com.example.tinkofflab2023.ui.fragment.player.model.PlayerModel

@Entity(tableName = "players")
data class PlayerEntity(
    val playerData: PlayerDataResponse,
    val wl: PlayerWLResponse,
    val heroes: PlayerHeroesResponse,
    val recentMatches: PlayerRecentMatchesResponse,
    @PrimaryKey
    val id: String = playerData.profile.accountId
)

fun PlayerEntity.toModel(): PlayerModel =
    PlayerModel(
        PlayerHeaderItem(playerData, wl),
        heroes,
        recentMatches
    )
