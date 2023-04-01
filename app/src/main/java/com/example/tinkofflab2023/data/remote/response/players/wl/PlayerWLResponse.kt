package com.example.tinkofflab2023.data.remote.response.players.wl


import com.google.gson.annotations.SerializedName

data class PlayerWLResponse(
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("win")
    val win: Int
)
