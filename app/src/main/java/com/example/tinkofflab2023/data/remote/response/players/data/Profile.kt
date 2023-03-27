package com.example.tinkofflab2023.data.remote.response.players.data


import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("account_id")
    val accountId: Int,
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("avatarfull")
    val avatarfull: String,
    @SerializedName("avatarmedium")
    val avatarmedium: String,
    @SerializedName("cheese")
    val cheese: Int,
    @SerializedName("is_contributor")
    val isContributor: Boolean,
    @SerializedName("is_subscriber")
    val isSubscriber: Boolean,
    @SerializedName("last_login")
    val lastLogin: String,
    @SerializedName("loccountrycode")
    val loccountrycode: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("personaname")
    val personaname: String,
    @SerializedName("plus")
    val plus: Boolean,
    @SerializedName("profileurl")
    val profileurl: String,
    @SerializedName("steamid")
    val steamid: String
)
