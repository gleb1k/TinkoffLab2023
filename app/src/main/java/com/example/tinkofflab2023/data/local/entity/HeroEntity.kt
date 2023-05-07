package com.example.tinkofflab2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "heroes")
data class HeroEntity(
    @SerializedName("id")
    @PrimaryKey
    val id: Int,
    @SerializedName("icon")
    val icon: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("localized_name")
    val localizedName: String,
)
