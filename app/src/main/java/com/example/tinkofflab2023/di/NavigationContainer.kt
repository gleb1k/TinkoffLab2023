package com.example.tinkofflab2023.di

import com.example.tinkofflab2023.presentation.fragment.TestFragment
import com.example.tinkofflab2023.presentation.fragment.favorite.FavoriteFragment
import com.example.tinkofflab2023.presentation.fragment.match.MatchFragment
import com.example.tinkofflab2023.presentation.fragment.player.PlayerFragment
import com.example.tinkofflab2023.presentation.fragment.search.SearchFragment
import com.example.tinkofflab2023.presentation.fragment.settings.SettingsFragment
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.androidx.FragmentScreen

object NavigationContainer {

    //region cicerone
    private val cicerone = Cicerone.create()
    val router get() = cicerone.router
    val navigatorHolder get() = cicerone.getNavigatorHolder()

    fun Main() = FragmentScreen { TestFragment() }
    fun Search() = FragmentScreen { SearchFragment() }
    fun Match(matchId: String) = FragmentScreen(matchId) { MatchFragment.newInstance(matchId) }
    //fragmentScreen key == accountId
    fun Player(accountId: String) = FragmentScreen(accountId) { PlayerFragment.newInstance(accountId) }
    fun Settings() = FragmentScreen { SettingsFragment() }
    fun Favorite() = FragmentScreen { FavoriteFragment() }
    //endregion
}
