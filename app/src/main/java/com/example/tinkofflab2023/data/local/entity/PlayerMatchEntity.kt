package com.example.tinkofflab2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tinkofflab2023.ui.model.PlayerMatchItem
import com.google.gson.annotations.SerializedName
import java.util.UUID

@Entity(tableName = "player_matches")
data class PlayerMatchEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val assists: Int,
    val averageRank: Int,
    val deaths: Int,
    val duration: Int,
    val gameMode: Int,
    val heroId: Int,
    val kills: Int,
    val lobbyType: Int,
    val matchId: String,
    val partySize: Int,
    val playerSlot: Int,
    val radiantWin: Boolean,
    val startTime: String,

    val accountId: String
)

fun List<PlayerMatchEntity>.addHeroes(heroesEntityList: List<HeroEntity>): List<PlayerMatchItem> {
    val playerList = arrayListOf<PlayerMatchItem>()
    forEach { response ->
        playerList.add(
            PlayerMatchItem(
                response,
                heroesEntityList.find { response.heroId == it.id }!!
            )
        )
    }
    return playerList
}
