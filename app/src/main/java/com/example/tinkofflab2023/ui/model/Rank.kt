package com.example.tinkofflab2023.ui.model

import androidx.annotation.DrawableRes
import com.example.tinkofflab2023.R

data class Rank(
    val name: String,
    val tier : Int,
    @DrawableRes
    val img : Int = R.drawable.not_calibrated,
)
