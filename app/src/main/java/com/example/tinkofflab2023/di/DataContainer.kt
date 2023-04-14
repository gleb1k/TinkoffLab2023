package com.example.tinkofflab2023.di

import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.DotaRepositoryImpl
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.domain.usecase.*
import com.example.tinkofflab2023.presentation.fragment.TestFragment
import com.example.tinkofflab2023.presentation.fragment.favorite.FavoriteFragment
import com.example.tinkofflab2023.presentation.fragment.match.MatchFragment
import com.example.tinkofflab2023.presentation.fragment.player.PlayerFragment
import com.example.tinkofflab2023.presentation.fragment.search.SearchFragment
import com.example.tinkofflab2023.presentation.fragment.settings.SettingsFragment
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.androidx.FragmentScreen
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//временная мера, потом будет Dagger,                                               или нет
object DataContainer {

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_DOTA_API_URL)
            .build()
    }

    private val dotaApi = retrofit.create(DotaApi::class.java)

    private val dotaRepository = DotaRepositoryImpl(dotaApi)

    val getMatchUseCase: GetMatchUseCase
        get() = GetMatchUseCase(dotaRepository)

    val searchPlayersUseCase: SearchPlayersUseCase
        get() = SearchPlayersUseCase(dotaRepository)

    val getPlayerHeroesUseCase: GetPlayerHeroesUseCase
        get() = GetPlayerHeroesUseCase(dotaRepository)

    val getPlayerResentMatchesUseCase: GetPlayerResentMatchesUseCase
        get() = GetPlayerResentMatchesUseCase(dotaRepository)

    val getPlayerDataUseCase: GetPlayerDataUseCase
        get() = GetPlayerDataUseCase(dotaRepository)

    val getPlayerWLUseCase: GetPlayerWLUseCase
        get() = GetPlayerWLUseCase(dotaRepository)

    val getItems: GetItemsUseCase
        get() = GetItemsUseCase(dotaRepository)

    val getHeroesUseCase: GetHeroesUseCase
        get() = GetHeroesUseCase(dotaRepository)

}
