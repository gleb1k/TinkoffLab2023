package com.example.tinkofflab2023.ui.model.match

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse

data class MatchOverviewModel(
    val matchResponse: MatchResponse,
    val players: List<MatchPlayerHeroItem>,
    val teamOutcomes: List<TeamOutcomeItem>,
)
