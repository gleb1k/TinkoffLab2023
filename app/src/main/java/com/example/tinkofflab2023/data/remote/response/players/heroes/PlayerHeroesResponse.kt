package com.example.tinkofflab2023.data.remote.response.players.heroes

import com.example.tinkofflab2023.data.local.entity.HeroEntity
import com.example.tinkofflab2023.ui.model.PlayerHeroItem


class PlayerHeroesResponse : ArrayList<PlayerHeroResponse>()

fun PlayerHeroesResponse.addHeroes(heroesEntityList: List<HeroEntity>): List<PlayerHeroItem> {
    val playerList = arrayListOf<PlayerHeroItem>()
    forEach { response ->
        playerList.add(
            PlayerHeroItem(
                response,
                heroesEntityList.find { response.heroId == it.id }!!
            )
        )
    }
    return playerList
}
