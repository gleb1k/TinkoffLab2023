package com.example.tinkofflab2023.core.utils

import android.view.View
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.ui.fragment.match.model.TeamOutcomeItem
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    message: String,
    duration: Int = Snackbar.LENGTH_LONG
) = Snackbar
    .make(this, message, duration)
    .show()

