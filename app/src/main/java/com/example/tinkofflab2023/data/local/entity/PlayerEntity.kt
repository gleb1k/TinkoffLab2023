package com.example.tinkofflab2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tinkofflab2023.data.local.converter.PlayerConverter
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.heroes.addHeroes
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.addHeroes
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.example.tinkofflab2023.data.remote.response.search.SearchPlayerResponse
import com.example.tinkofflab2023.ui.model.PlayerHeaderItem
import com.example.tinkofflab2023.ui.model.PlayerModel

@Entity(tableName = "players")
@TypeConverters(PlayerConverter::class)
data class PlayerEntity(
    val playerData: PlayerDataResponse,
    val wl: PlayerWLResponse,
    val heroes: PlayerHeroesResponse,
    val recentMatches: PlayerMatchesResponse,
    val isFavorite: Boolean = false,

    @PrimaryKey
    val id: String = playerData.profile.accountId,
)

fun PlayerEntity.toModel(heroesEntityList: List<HeroEntity>): PlayerModel =
    PlayerModel(
        PlayerHeaderItem(playerData, wl),
        heroes.addHeroes(heroesEntityList),
        recentMatches.addHeroes(heroesEntityList),
        isFavorite
    )

fun PlayerEntity.toSearchResponse(): SearchPlayerResponse =
    SearchPlayerResponse(
        accountId = playerData.profile.accountId,
        avatarfull = playerData.profile.avatarfull,
        lastMatchTime = "NOT IMPL",
        personaname = playerData.profile.personaname,
        similarity = 0.0,
    )
