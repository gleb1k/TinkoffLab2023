package com.example.tinkofflab2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tinkofflab2023.data.local.converter.MatchConverter
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.matches.getTeamsOutcomes
import com.example.tinkofflab2023.data.remote.response.matches.toItem
import com.example.tinkofflab2023.ui.model.MatchModel
import com.example.tinkofflab2023.ui.model.addHeroesAndItems

@Entity(tableName = "matches")
@TypeConverters(MatchConverter::class)
data class MatchEntity(
    val matchResponse: MatchResponse,
    val isFavorite: Boolean = false,
    @PrimaryKey
    val id: String = matchResponse.matchId
)

fun MatchEntity.toModel(heroesEntityList: List<HeroEntity>, items: List<ItemEntity>): MatchModel =
    MatchModel(
        matchResponse.toItem(),
        matchResponse.players.addHeroesAndItems(heroesEntityList, items),
        matchResponse.getTeamsOutcomes()
    )

fun MatchEntity.toResponse(): MatchResponse = matchResponse
