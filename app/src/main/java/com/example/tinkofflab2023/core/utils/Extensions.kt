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

fun MatchResponse.getTeamsOutcomes(): List<TeamOutcomeItem> {

    var killsR = 0
    var deathsR = 0
    var assistsR = 0
    var netR = 0

    var killsD = 0
    var deathsD = 0
    var assistsD = 0
    var netD = 0

    players.forEach {
        if (it.isRadiant) {
            killsR += it.kills
            deathsR += it.deaths
            assistsR += it.assists
            netR += it.netWorth
        } else {
            killsD += it.kills
            deathsD += it.deaths
            assistsD += it.assists
            netD += it.netWorth
        }
    }
    return listOf(
        TeamOutcomeItem(true, killsR, deathsR, assistsR, netR),
        TeamOutcomeItem(false, killsD, deathsD, assistsD, netD),
    )
}
