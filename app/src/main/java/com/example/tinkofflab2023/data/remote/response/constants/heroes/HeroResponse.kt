package com.example.tinkofflab2023.data.remote.response.constants.heroes


import com.google.gson.annotations.SerializedName

data class HeroResponse(
    @SerializedName("agi_gain")
    val agiGain: Double,
    @SerializedName("attack_point")
    val attackPoint: Double,
    @SerializedName("attack_range")
    val attackRange: Double,
    @SerializedName("attack_rate")
    val attackRate: Double,
    @SerializedName("attack_type")
    val attackType: String,
    @SerializedName("base_agi")
    val baseAgi: Double,
    @SerializedName("base_armor")
    val baseArmor: Double,
    @SerializedName("base_attack_max")
    val baseAttackMax: Double,
    @SerializedName("base_attack_min")
    val baseAttackMin: Double,
    @SerializedName("base_attack_time")
    val baseAttackTime: Double,
    @SerializedName("base_health")
    val baseHealth: Double,
    @SerializedName("base_health_regen")
    val baseHealthRegen: Double,
    @SerializedName("base_int")
    val baseInt: Double,
    @SerializedName("base_mana")
    val baseMana: Double,
    @SerializedName("base_mana_regen")
    val baseManaRegen: Double,
    @SerializedName("base_mr")
    val baseMr: Double,
    @SerializedName("base_str")
    val baseStr: Double,
    @SerializedName("cm_enabled")
    val cmEnabled: Boolean,
    @SerializedName("day_vision")
    val dayVision: Double,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("int_gain")
    val intGain: Double,
    @SerializedName("localized_name")
    val localizedName: String,
    @SerializedName("move_speed")
    val moveSpeed: Double,
    @SerializedName("name")
    val name: String,
    @SerializedName("night_vision")
    val nightVision: Double,
    @SerializedName("primary_attr")
    val primaryAttr: String,
    @SerializedName("projectile_speed")
    val projectileSpeed: Double,
    @SerializedName("roles")
    val roles: List<String>,
    @SerializedName("str_gain")
    val strGain: Double,
)
