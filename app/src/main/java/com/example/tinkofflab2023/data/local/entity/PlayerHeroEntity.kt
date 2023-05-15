package com.example.tinkofflab2023.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tinkofflab2023.ui.model.PlayerHeroItem
import com.google.gson.annotations.SerializedName
import java.util.UUID

@Entity(tableName = "player_heroes")
data class PlayerHeroEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val games: Int,
    val heroId: Int,
    val lastPlayed: String,
    val win: Int,

    val accountId: String
)

fun List<PlayerHeroEntity>.addHeroes(heroesEntityList: List<HeroEntity>): List<PlayerHeroItem> {
    val playerList = arrayListOf<PlayerHeroItem>()
    forEach { response ->
        playerList.add(
            PlayerHeroItem(
                response,
                heroesEntityList.find { response.heroId == it.id }!!
            )
        )
    }
    return playerList
}

fun List<PlayerHeroEntity>.clearNeverPlayedHeroes(): List<PlayerHeroEntity> {
    return ArrayList(this).filter { it.lastPlayed != "0" }
}
