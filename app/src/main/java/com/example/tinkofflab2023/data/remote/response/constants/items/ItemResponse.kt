package com.example.tinkofflab2023.data.remote.response.constants.items


import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.local.entity.ItemEntity
import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("cd")
    val cd: Any,
    @SerializedName("cost")
    val cost: Int,
    @SerializedName("dname")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("img")
    val img: String,
    @SerializedName("lore")
    val lore: String,
    @SerializedName("notes")
    val notes: String,
    @SerializedName("qual")
    val qual: String
)

fun ItemResponse.toEntity(): ItemEntity = ItemEntity(
    id,
    Constants.DOTA_API_IMAGE_URL + img,
    cost,
    name
)
