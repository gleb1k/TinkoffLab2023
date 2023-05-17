package com.example.tinkofflab2023.di

import com.example.tinkofflab2023.ui.fragment.TestFragment
import com.example.tinkofflab2023.ui.fragment.favorite.FavoriteFragment
import com.example.tinkofflab2023.ui.fragment.match.MatchFragment
import com.example.tinkofflab2023.ui.fragment.match.overview.MatchOverviewFragment
import com.example.tinkofflab2023.ui.fragment.player.PlayerFragment
import com.example.tinkofflab2023.ui.fragment.search.SearchFragment
import com.example.tinkofflab2023.ui.fragment.settings.SettingsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun Search() = FragmentScreen { SearchFragment() }
    fun Match(matchId: String) =
        FragmentScreen(matchId) { MatchFragment.newInstance(matchId) }

    //fragmentScreen key == accountId
    fun Player(accountId: String) =
        FragmentScreen(accountId) { PlayerFragment.newInstance(accountId) }

    fun Settings() = FragmentScreen { SettingsFragment() }
    fun Favorite() = FragmentScreen { FavoriteFragment() }

}
