package com.example.tinkofflab2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tinkofflab2023.data.local.converter.PlayerConverter
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse

@Entity(tableName = "players")
@TypeConverters(PlayerConverter::class)
data class PlayerData(
    val data: PlayerDataResponse,
    val wl: PlayerWLResponse,
    val isFavorite: Boolean = false,
    @PrimaryKey
    val id: String = data.profile.accountId,
)

