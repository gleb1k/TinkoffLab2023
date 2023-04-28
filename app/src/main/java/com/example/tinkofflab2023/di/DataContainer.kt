package com.example.tinkofflab2023.di

import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.DotaRepositoryImpl
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.domain.usecase.*
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

    val getTeamsOutcomesUseCase: GetTeamsOutcomesUseCase
        get() = GetTeamsOutcomesUseCase(dotaRepository)

    val getTeamsPlayersUseCase: GetTeamsPlayersUseCase
        get() = GetTeamsPlayersUseCase(dotaRepository)

    val getPlayerOverviewModelUseCase: GetPlayerOverviewModelUseCase
        get() = GetPlayerOverviewModelUseCase(dotaRepository)

}
