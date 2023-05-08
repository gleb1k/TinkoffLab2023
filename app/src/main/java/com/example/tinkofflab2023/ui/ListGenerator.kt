package com.example.tinkofflab2023.ui

import com.example.tinkofflab2023.ui.model.MatchModel
import com.example.tinkofflab2023.ui.model.PlayerModel

fun generatePlayerOverview(player: PlayerModel): ArrayList<Any> {
    try {
        return ArrayList<Any>().apply {
            with(player) {
                add(header)
                add("Latest Matches")
                if (recentMatches.size >= 5) {
                    for (i in 0..4)
                        add(recentMatches[i])
                } else
                    add("Matches doesn't found")
                if (heroes.size >= 5) {
                    add("Most played Heroes")
                    for (i in 0..4)
                        add(heroes[i])
                } else
                    add("Heroes doesn't found")
            }
        }
    } catch (throwable: Throwable) {
        return arrayListOf("Error :с")
    }
}

fun generateMatchOverview(matchModel: MatchModel): ArrayList<Any> {
    try {
        return ArrayList<Any>().apply {
            with(matchModel) {
                add(matchItem)
                add("The Radiant")
                for (i in 0..4)
                    add(players[i])
                add(teamOutcomes[0])
                add("The Dire")
                for (i in 5..9)
                    add(players[i])
                add(teamOutcomes[0])
            }
        }
    } catch (throwable: Throwable) {
        return arrayListOf("Error :с")
    }
}
