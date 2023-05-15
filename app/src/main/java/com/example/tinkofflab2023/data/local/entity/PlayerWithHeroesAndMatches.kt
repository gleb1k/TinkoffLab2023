package com.example.tinkofflab2023.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.ui.model.PlayerHeaderItem
import com.example.tinkofflab2023.ui.model.PlayerModel

data class PlayerEntity(
    @Embedded
    val playerData: PlayerData,
    @Relation(
        parentColumn = "id",
        entityColumn = "accountId"
    )
    val heroes: List<PlayerHeroEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "accountId"
    )
    val recentMatches: List<PlayerMatchEntity>,
)

fun PlayerEntity.toModel(heroesEntityList: List<HeroEntity>): PlayerModel =
    PlayerModel(
        PlayerHeaderItem(playerData.data, playerData.wl),
        heroes.addHeroes(heroesEntityList),
        recentMatches.addHeroes(heroesEntityList),
        isFavorite = playerData.isFavorite
    )

fun PlayerEntity.toSearchResponse(): SearchPlayerResponse =
    SearchPlayerResponse(
        accountId = playerData.data.profile.accountId,
        avatarfull = playerData.data.profile.avatarfull,
        lastMatchTime = "NOT IMPL",
        personaname = playerData.data.profile.personaname,
        similarity = 0.0,
    )
