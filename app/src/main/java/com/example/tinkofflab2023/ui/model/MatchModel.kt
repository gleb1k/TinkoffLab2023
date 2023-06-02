package com.example.tinkofflab2023.ui.model

import com.example.tinkofflab2023.data.local.entity.HeroEntity
import com.example.tinkofflab2023.data.local.entity.ItemEntity
import com.example.tinkofflab2023.data.remote.response.matches.PicksBan
import com.example.tinkofflab2023.data.remote.response.matches.Player

data class MatchModel(
    val matchItem: MatchItem,
    val players: List<MatchPlayerItem>,
    val teamOutcomes: List<MatchTeamOutcomeItem>,
)

data class MatchTeamOutcomeItem(
    val isRadiant: Boolean,
    val summaryKills: Int,
    val summaryDeaths: Int,
    val summaryAssists: Int,
    val summaryNet: Int
)

/*
 *   Player in match, with benchmarks and stats
 */
data class MatchPlayerItem(
    val player: Player,
    val heroEntity: HeroEntity,
    val items: List<ItemEntity>,
    val backpackItems: List<ItemEntity>,
    val itemNeutral: ItemEntity,
)

data class MatchItem(
    val barracksStatusDire: Int,
    val barracksStatusRadiant: Int,
    val cluster: Int?,
    val direScore: Int?,
    val duration: Int,
    val engine: Int?,
    val firstBloodTime: Int?,
    val gameMode: Int?,
    val leagueid: Int?,
    val lobbyType: Int,
    val matchId: String,
    val patch: Int?,
    val picksBans: List<PicksBan>?,
    val positiveVotes: Int?,
    val radiantScore: Int?,
    val radiantWin: Boolean,
    val region: Int?,
    val replayUrl: String?,
    val startTime: String,
    val towerStatusDire: Int,
    val towerStatusRadiant: Int,
)

//todo null safety
fun List<Player>.addHeroesAndItems(
    heroes: List<HeroEntity>,
    items: List<ItemEntity>
): List<MatchPlayerItem> {
    val playerList = arrayListOf<MatchPlayerItem>()
    forEach { player ->
        playerList.add(
            MatchPlayerItem(
                player,
                heroes.find { player.heroId == it.id }!!,
                player.getItems(items),
                player.getBackpackItems(items),
                player.getItemNeutral(items)
            )
        )
    }
    return playerList
}


private fun Player.getItems(items: List<ItemEntity>): List<ItemEntity> {
    val emptyItem = ItemEntity(0, "", 0, "")
    val result = arrayListOf<ItemEntity>()

    result.add(items.find { item0 == it.id } ?: emptyItem)
    result.add(items.find { item1 == it.id } ?: emptyItem)
    result.add(items.find { item2 == it.id } ?: emptyItem)
    result.add(items.find { item3 == it.id } ?: emptyItem)
    result.add(items.find { item4 == it.id } ?: emptyItem)
    result.add(items.find { item5 == it.id } ?: emptyItem)

    return result
}

private fun Player.getBackpackItems(items: List<ItemEntity>): List<ItemEntity> {
    val emptyItem = ItemEntity(0, "", 0, "")
    val result = arrayListOf<ItemEntity>()

    result.add(items.find { backpack0 == it.id } ?: emptyItem)
    result.add(items.find { backpack1 == it.id } ?: emptyItem)
    result.add(items.find { backpack2 == it.id } ?: emptyItem)

    return result
}

private fun Player.getItemNeutral(items: List<ItemEntity>): ItemEntity {
    return items.find { itemNeutral == it.id } ?: ItemEntity(0, "", 0, "")
}
