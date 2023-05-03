package com.example.tinkofflab2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.matches.getTeamsOutcomes
import com.example.tinkofflab2023.ui.fragment.match.model.MatchModel

@Entity(tableName = "matches")
data class MatchEntity(
    val matchResponse: MatchResponse,
    @PrimaryKey
    val id: String = matchResponse.matchId
)

fun MatchEntity.toModel(): MatchModel =
    MatchModel(
        matchResponse,
        matchResponse.getTeamsOutcomes()
    )