package com.example.tinkofflab2023.data.remote.response.players.data


import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("account_id")
    val accountId: String,
    @SerializedName("avatarfull")
    val avatarfull: String,
    @SerializedName("last_login")
    val lastLogin: String,
    @SerializedName("personaname")
    val personaname: String,
    //dota plus
    @SerializedName("plus")
    val plus: Boolean,
    @SerializedName("profileurl")
    val profileurl: String,
    @SerializedName("steamid")
    val steamid: String
)
