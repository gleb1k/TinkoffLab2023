package com.example.tinkofflab2023.data.remote.response.matches


import com.google.gson.annotations.SerializedName

data class PicksBan(
    @SerializedName("hero_id")
    val heroId: Int,
    @SerializedName("is_pick")
    val isPick: Boolean,
    @SerializedName("order")
    val order: Int,
    @SerializedName("team")
    val team: Int
)
