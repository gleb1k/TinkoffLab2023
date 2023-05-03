package com.example.tinkofflab2023.ui.fragment.match.model

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse

data class MatchModel(
    val matchResponse: MatchResponse,
    val players: List<MatchPlayerHeroItem>,
    val teamOutcomes: List<TeamOutcomeItem>,
)
