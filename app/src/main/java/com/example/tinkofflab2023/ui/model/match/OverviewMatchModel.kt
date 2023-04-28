package com.example.tinkofflab2023.ui.model.match

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse

data class OverviewMatchModel(
    val matchResponse: MatchResponse,
    val teamOutcomeItem: TeamOutcomeItem,
    val teamPlayerItem: TeamPlayerItem
    )
