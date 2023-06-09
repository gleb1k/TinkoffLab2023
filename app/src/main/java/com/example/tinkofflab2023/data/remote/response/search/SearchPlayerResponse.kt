package com.example.tinkofflab2023.data.remote.response.search


import com.google.gson.annotations.SerializedName

data class SearchPlayerResponse(
    @SerializedName("account_id")
    val accountId: String,
    @SerializedName("avatarfull")
    val avatarfull: String,
    @SerializedName("last_match_time")
    val lastMatchTime: String,
    @SerializedName("personaname")
    val personaname: String,
    @SerializedName("similarity")
    val similarity: Double
)
