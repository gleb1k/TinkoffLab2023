package com.example.tinkofflab2023.di

import androidx.room.Room
import com.example.tinkofflab2023.core.App
import com.example.tinkofflab2023.data.*
import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.domain.usecase.*
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//временная мера, потом будет Dagger,                  или нет
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

    private val api = retrofit.create(DotaApi::class.java)

    private val db by lazy {
        Room.databaseBuilder(App.INSTANCE, AppDatabase::class.java, Constants.DOTA_DATABASE_NAME)
            .build()
    }

    private val repositoryLocal = DotaRepositoryLocal(db)

    private val repositoryRemote = DotaRepositoryRemote(
        api
    )

    private val repository = Repository(
        repositoryLocal,
        repositoryRemote
    )

    //todo delete
    private val dotaRepository = DotaRepositoryImpl(api)

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

    val getPlayerModelUseCase: GetPlayerModelUseCase
        get() = GetPlayerModelUseCase(dotaRepository)

    val getMatchOverviewModelUseCase: GetMatchOverviewModelUseCase
        get() = GetMatchOverviewModelUseCase(dotaRepository)
}
