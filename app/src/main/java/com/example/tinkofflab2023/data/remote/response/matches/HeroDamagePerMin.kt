package com.example.tinkofflab2023.data.remote.response.matches


import com.google.gson.annotations.SerializedName

data class HeroDamagePerMin(
    @SerializedName("pct")
    val pct: Double,
    @SerializedName("raw")
    val raw: Double
)
