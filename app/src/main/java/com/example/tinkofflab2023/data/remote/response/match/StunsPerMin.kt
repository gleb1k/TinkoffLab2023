package com.example.tinkofflab2023.data.remote.response.match


import com.google.gson.annotations.SerializedName

data class StunsPerMin(
    @SerializedName("pct")
    val pct: Double,
    @SerializedName("raw")
    val raw: Int
)
