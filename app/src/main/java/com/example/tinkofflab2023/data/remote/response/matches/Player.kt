package com.example.tinkofflab2023.data.remote.response.matches


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("ability_upgrades_arr")
    val abilityUpgradesArr: List<Int>,
    @SerializedName("account_id")
    val accountId: String?,
    @SerializedName("assists")
    val assists: Int,
    @SerializedName("backpack_0")
    val backpack0: Int,
    @SerializedName("backpack_1")
    val backpack1: Int,
    @SerializedName("backpack_2")
    val backpack2: Int,
    @SerializedName("benchmarks")
    val benchmarks: Benchmarks,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("denies")
    val denies: Int,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("game_mode")
    val gameMode: Int,
    @SerializedName("gold")
    val gold: Int,
    @SerializedName("gold_per_min")
    val goldPerMin: Int,
    @SerializedName("gold_spent")
    val goldSpent: Int,
    @SerializedName("hero_damage")
    val heroDamage: Int,
    @SerializedName("hero_healing")
    val heroHealing: Int,
    @SerializedName("hero_id")
    val heroId: Int,
    @SerializedName("isRadiant")
    val isRadiant: Boolean,
    @SerializedName("item_0")
    val item0: Int,
    @SerializedName("item_1")
    val item1: Int,
    @SerializedName("item_2")
    val item2: Int,
    @SerializedName("item_3")
    val item3: Int,
    @SerializedName("item_4")
    val item4: Int,
    @SerializedName("item_5")
    val item5: Int,
    @SerializedName("item_neutral")
    val itemNeutral: Int,
    @SerializedName("kda")
    val kda: Int,
    @SerializedName("kills")
    val kills: Int,
    @SerializedName("kills_per_min")
    val killsPerMin: Double,
    @SerializedName("last_hits")
    val lastHits: Int,
    @SerializedName("level")
    val level: Int,
    @SerializedName("lobby_type")
    val lobbyType: Int,
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("net_worth")
    val netWorth: Int,
    @SerializedName("party_id")
    val partyId: Int,
    @SerializedName("party_size")
    val partySize: Int,
    @SerializedName("permanent_buffs")
    val permanentBuffs: List<PermanentBuff>,
    @SerializedName("personaname")
    val personaname: String?,
    @SerializedName("player_slot")
    val playerSlot: Int,
    @SerializedName("radiant_win")
    val radiantWin: Boolean,
    @SerializedName("rank_tier")
    val rankTier: Int,
    @SerializedName("start_time")
    val startTime: Int,
    @SerializedName("total_gold")
    val totalGold: Int,
    @SerializedName("total_xp")
    val totalXp: Int,
    @SerializedName("tower_damage")
    val towerDamage: Int,
    @SerializedName("win")
    val win: Int,
    @SerializedName("xp_per_min")
    val xpPerMin: Int,
)
