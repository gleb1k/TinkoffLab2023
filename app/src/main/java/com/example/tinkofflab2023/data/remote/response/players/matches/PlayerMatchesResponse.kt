package com.example.tinkofflab2023.data.remote.response.players.matches

import com.example.tinkofflab2023.data.local.entity.HeroEntity
import com.example.tinkofflab2023.ui.model.PlayerMatchItem


class PlayerMatchesResponse : ArrayList<PlayerMatchResponse>()

fun PlayerMatchesResponse.addHeroes(heroesEntityList: List<HeroEntity>): List<PlayerMatchItem> {
    val playerList = arrayListOf<PlayerMatchItem>()
    forEachIndexed {index, response ->
        playerList.add(
            PlayerMatchItem(
                response,
                heroesEntityList.find { response.heroId == it.id }!!,
                index
            )
        )
    }
    return playerList
}
