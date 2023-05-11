package com.example.tinkofflab2023.ui.util

import android.content.Context
import com.example.tinkofflab2023.R
import com.example.tinkofflab2023.ui.model.MatchModel
import com.example.tinkofflab2023.ui.model.PlayerModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ViewGenerator @Inject constructor(
    @ApplicationContext private val context: Context
) {

    private fun ArrayList<Any>.addFiveElementsIfPossible(
        elements: List<Any>?
    ): ArrayList<Any> {
        if (elements.isNullOrEmpty()) {
            add(context.getString(R.string.doesnt_found))
            return this
        }
        var count = 0
        for (elem in elements) {
            add(elem)
            count++
            if (count == 5)
                break
        }
        return this
    }

    fun generatePlayerOverview(player: PlayerModel): ArrayList<Any> {
        return try {
            ArrayList<Any>().apply {
                with(player) {
                    add(header)
                    add(context.getString(R.string.latest_matches))
                    addFiveElementsIfPossible(recentMatches)
                    add(context.getString(R.string.most_played_heroes))
                    addFiveElementsIfPossible(heroes)
                }
            }
        } catch (throwable: Throwable) {
            arrayListOf(context.getString(R.string.an_error_has_occurred))
        }
    }

    fun generateMatchOverview(matchModel: MatchModel): ArrayList<Any> {
        try {
            return ArrayList<Any>().apply {
                with(matchModel) {
                    add(matchItem)
                    add(context.getString(R.string.the_radiant))
                    for (i in 0..4)
                        add(players[i])
                    addFiveElementsIfPossible(players.subList(0, 4))
                    add(teamOutcomes[0])
                    add(context.getString(R.string.the_dire))
                    for (i in 5..9)
                        add(players[i])
                    add(teamOutcomes[1])
                }
            }
        } catch (throwable: Throwable) {
            return arrayListOf(context.getString(R.string.an_error_has_occurred))
        }
    }
}
