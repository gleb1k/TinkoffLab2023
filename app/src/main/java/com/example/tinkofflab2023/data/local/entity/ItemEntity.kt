package com.example.tinkofflab2023.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemEntity(
    @PrimaryKey
    val id: Int,
    val img: String?,
    val cost: Int?,
    val name: String?,
)
