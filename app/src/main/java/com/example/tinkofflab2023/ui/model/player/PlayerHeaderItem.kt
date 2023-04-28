package com.example.tinkofflab2023.ui.model.player

import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse

data class PlayerHeaderItem(
    val playerDataResponse: PlayerDataResponse,
    val playerWL : PlayerWLResponse,
)