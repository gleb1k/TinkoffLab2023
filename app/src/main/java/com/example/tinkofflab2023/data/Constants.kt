package com.example.tinkofflab2023.data

import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse


object Constants {
    const val BASE_DOTA_API_URL = "https://api.opendota.com/api/"
    const val DOTA_API_IMAGE_URL = "https://api.opendota.com"

    const val DOTA_DATABASE_NAME = "dota_db"

    const val RADIANT = "RADIANT"
    const val DIRE = "DIRE"

    var favoritePLayers = arrayListOf<PlayerDataResponse>()

    var favoriteMatches = arrayListOf<MatchResponse>()

    val lobbyTypes = mapOf(
        0 to "Normal",
        1 to "Practice",
        2 to "Tournament",
        3 to "Tutorial",
        4 to "Coop Bots",
        5 to "Ranked Team MM",
        6 to "Ranked Solo MM",
        7 to "Ranked",
        8 to "1v1 Mid",
        9 to "Battle Cup",
        10 to "Local Bots",
        11 to "Spectator",
        12 to "Event",
        13 to "Gauntlet",
        14 to "New Player",
        15 to "Featured",
    )

    val gameModes = mapOf(
        22 to "All Pick",
        23 to "Turbo",
        4 to "Single Draft",
        0 to "Unknown",

        1 to "All Pick",
        2 to "Captains Mode",
        3 to "Random Draft",
        5 to "All Random",
        6 to "Intro",
        7 to "Diretide",
        8 to "Reverse Captains Mode",
        9 to "Greeviling",
        10 to "Tutorial",
        11 to "Mid Only",
        12 to "Least Played",
        13 to "Limited Heroes",
        14 to "Compendium Matchmaking",
        15 to "Custom",
        16 to "Captains Draft",
        17 to "Balanced Draft",
        18 to "Ability Draft",
        19 to "Event",
        20 to "All Random Death Match",
        21 to "1v1_mid",
        24 to "Mutation",
        25 to "Coaches Challenge"
    )
}
