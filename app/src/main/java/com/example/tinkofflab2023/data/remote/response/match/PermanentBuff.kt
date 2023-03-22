package com.example.tinkofflab2023.data.remote.response.match


import com.google.gson.annotations.SerializedName

data class PermanentBuff(
    @SerializedName("grant_time")
    val grantTime: Int,
    @SerializedName("permanent_buff")
    val permanentBuff: Int,
    @SerializedName("stack_count")
    val stackCount: Int
)
