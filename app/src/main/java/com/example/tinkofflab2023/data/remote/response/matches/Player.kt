package com.example.tinkofflab2023.data.remote.response.matches


import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("abandons")
    val abandons: Int,
    @SerializedName("ability_targets")
    val abilityTargets: Any,
    @SerializedName("ability_upgrades_arr")
    val abilityUpgradesArr: List<Int>,
    @SerializedName("ability_uses")
    val abilityUses: Any,
    @SerializedName("account_id")
    val accountId: String,
    @SerializedName("actions")
    val actions: Any,
    @SerializedName("additional_units")
    val additionalUnits: Any,
    @SerializedName("assists")
    val assists: Int,
    @SerializedName("backpack_0")
    val backpack0: Int,
    @SerializedName("backpack_1")
    val backpack1: Int,
    @SerializedName("backpack_2")
    val backpack2: Int,
    @SerializedName("backpack_3")
    val backpack3: Any,
    @SerializedName("benchmarks")
    val benchmarks: Benchmarks,
    @SerializedName("buyback_log")
    val buybackLog: Any,
    @SerializedName("camps_stacked")
    val campsStacked: Any,
    @SerializedName("cluster")
    val cluster: Int,
    @SerializedName("connection_log")
    val connectionLog: Any,
    @SerializedName("cosmetics")
    val cosmetics: List<Any>,
    @SerializedName("creeps_stacked")
    val creepsStacked: Any,
    @SerializedName("damage")
    val damage: Any,
    @SerializedName("damage_inflictor")
    val damageInflictor: Any,
    @SerializedName("damage_inflictor_received")
    val damageInflictorReceived: Any,
    @SerializedName("damage_taken")
    val damageTaken: Any,
    @SerializedName("damage_targets")
    val damageTargets: Any,
    @SerializedName("deaths")
    val deaths: Int,
    @SerializedName("denies")
    val denies: Int,
    @SerializedName("dn_t")
    val dnT: Any,
    @SerializedName("duration")
    val duration: Int,
    @SerializedName("firstblood_claimed")
    val firstbloodClaimed: Any,
    @SerializedName("game_mode")
    val gameMode: Int,
    @SerializedName("gold")
    val gold: Int,
    @SerializedName("gold_per_min")
    val goldPerMin: Int,
    @SerializedName("gold_reasons")
    val goldReasons: Any,
    @SerializedName("gold_spent")
    val goldSpent: Int,
    @SerializedName("gold_t")
    val goldT: Any,
    @SerializedName("hero_damage")
    val heroDamage: Int,
    @SerializedName("hero_healing")
    val heroHealing: Int,
    @SerializedName("hero_hits")
    val heroHits: Any,
    @SerializedName("hero_id")
    val heroId: Int,
    @SerializedName("is_contributor")
    val isContributor: Boolean,
    @SerializedName("isRadiant")
    val isRadiant: Boolean,
    @SerializedName("is_subscriber")
    val isSubscriber: Boolean,
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
    @SerializedName("item_uses")
    val itemUses: Any,
    @SerializedName("kda")
    val kda: Int,
    @SerializedName("kill_streaks")
    val killStreaks: Any,
    @SerializedName("killed")
    val killed: Any,
    @SerializedName("killed_by")
    val killedBy: Any,
    @SerializedName("kills")
    val kills: Int,
    @SerializedName("kills_log")
    val killsLog: Any,
    @SerializedName("kills_per_min")
    val killsPerMin: Double,
    @SerializedName("lane_pos")
    val lanePos: Any,
    @SerializedName("last_hits")
    val lastHits: Int,
    @SerializedName("last_login")
    val lastLogin: String,
    @SerializedName("leaver_status")
    val leaverStatus: Int,
    @SerializedName("level")
    val level: Int,
    @SerializedName("lh_t")
    val lhT: Any,
    @SerializedName("life_state")
    val lifeState: Any,
    @SerializedName("lobby_type")
    val lobbyType: Int,
    @SerializedName("lose")
    val lose: Int,
    @SerializedName("match_id")
    val matchId: Long,
    @SerializedName("max_hero_hit")
    val maxHeroHit: Any,
    @SerializedName("multi_kills")
    val multiKills: Any,
    @SerializedName("name")
    val name: Any,
    @SerializedName("net_worth")
    val netWorth: Int,
    @SerializedName("obs")
    val obs: Any,
    @SerializedName("obs_left_log")
    val obsLeftLog: Any,
    @SerializedName("obs_log")
    val obsLog: Any,
    @SerializedName("obs_placed")
    val obsPlaced: Any,
    @SerializedName("party_id")
    val partyId: Int,
    @SerializedName("party_size")
    val partySize: Int,
    @SerializedName("patch")
    val patch: Int,
    @SerializedName("performance_others")
    val performanceOthers: Any,
    @SerializedName("permanent_buffs")
    val permanentBuffs: List<PermanentBuff>,
    @SerializedName("personaname")
    val personaname: String?,
    @SerializedName("pings")
    val pings: Any,
    @SerializedName("player_slot")
    val playerSlot: Int,
    @SerializedName("pred_vict")
    val predVict: Any,
    @SerializedName("purchase")
    val purchase: Any,
    @SerializedName("purchase_log")
    val purchaseLog: Any,
    @SerializedName("radiant_win")
    val radiantWin: Boolean,
    @SerializedName("randomed")
    val randomed: Any,
    @SerializedName("rank_tier")
    val rankTier: Int,
    @SerializedName("region")
    val region: Int,
    @SerializedName("repicked")
    val repicked: Any,
    @SerializedName("roshans_killed")
    val roshansKilled: Any,
    @SerializedName("rune_pickups")
    val runePickups: Any,
    @SerializedName("runes")
    val runes: Any,
    @SerializedName("runes_log")
    val runesLog: Any,
    @SerializedName("sen")
    val sen: Any,
    @SerializedName("sen_left_log")
    val senLeftLog: Any,
    @SerializedName("sen_log")
    val senLog: Any,
    @SerializedName("sen_placed")
    val senPlaced: Any,
    @SerializedName("start_time")
    val startTime: Int,
    @SerializedName("stuns")
    val stuns: Any,
    @SerializedName("teamfight_participation")
    val teamfightParticipation: Any,
    @SerializedName("times")
    val times: Any,
    @SerializedName("total_gold")
    val totalGold: Int,
    @SerializedName("total_xp")
    val totalXp: Int,
    @SerializedName("tower_damage")
    val towerDamage: Int,
    @SerializedName("towers_killed")
    val towersKilled: Any,
    @SerializedName("win")
    val win: Int,
    @SerializedName("xp_per_min")
    val xpPerMin: Int,
    @SerializedName("xp_reasons")
    val xpReasons: Any,
    @SerializedName("xp_t")
    val xpT: Any
)
