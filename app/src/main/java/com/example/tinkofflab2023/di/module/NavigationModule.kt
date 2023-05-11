package com.example.tinkofflab2023.di.module

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//todo how to provide screens?
@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {

    @Provides
    @Singleton
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Provides
    @Singleton
    fun provideRouter(
        cicerone: Cicerone<Router>
    ): Router = cicerone.router

    @Provides
    @Singleton
    fun provideNavigatorHolder(
        cicerone: Cicerone<Router>
    ): NavigatorHolder = cicerone.getNavigatorHolder()

//    fun Search() = FragmentScreen { SearchFragment() }
//    fun Match(matchId: String) =
//        FragmentScreen(matchId) { MatchOverviewFragment.newInstance(matchId) }
//
//    //fragmentScreen key == accountId
//    fun Player(accountId: String) =
//        FragmentScreen(accountId) { PlayerFragment.newInstance(accountId) }
//
//    fun Settings() = FragmentScreen { SettingsFragment() }
//    fun Favorite() = FragmentScreen { FavoriteFragment() }
}
