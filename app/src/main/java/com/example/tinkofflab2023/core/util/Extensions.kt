package com.example.tinkofflab2023.core.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    message: String,
    duration: Int = Snackbar.LENGTH_LONG
) = Snackbar
    .make(this, message, duration)
    .show()

fun String.isNumeric(): Boolean = this.toDoubleOrNull() != null
