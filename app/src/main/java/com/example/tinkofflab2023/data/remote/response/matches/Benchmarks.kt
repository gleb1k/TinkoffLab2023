package com.example.tinkofflab2023.data.remote.response.matches


import com.google.gson.annotations.SerializedName

data class Benchmarks(
    @SerializedName("gold_per_min")
    val goldPerMin: GoldPerMin,
    @SerializedName("hero_damage_per_min")
    val heroDamagePerMin: HeroDamagePerMin,
    @SerializedName("hero_healing_per_min")
    val heroHealingPerMin: HeroHealingPerMin,
    @SerializedName("kills_per_min")
    val killsPerMin: KillsPerMin,
    @SerializedName("last_hits_per_min")
    val lastHitsPerMin: LastHitsPerMin,
    @SerializedName("lhten")
    val lhten: Lhten,
    @SerializedName("stuns_per_min")
    val stunsPerMin: StunsPerMin,
    @SerializedName("tower_damage")
    val towerDamage: TowerDamage,
    @SerializedName("xp_per_min")
    val xpPerMin: XpPerMin
)
