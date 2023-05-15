package com.example.tinkofflab2023.data.remote.response.matches


import com.google.gson.annotations.SerializedName

data class Benchmarks(
    @SerializedName("gold_per_min")
    val goldPerMin: GoldPerMin,
    @SerializedName("kills_per_min")
    val killsPerMin: KillsPerMin,
    @SerializedName("xp_per_min")
    val xpPerMin: XpPerMin
)
