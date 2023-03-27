package com.example.tinkofflab2023.di

import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.DotaRepositoryImpl
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.domain.usecase.GetMatchUseCase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//временная мера, потом будет Dagger
object DataContainer {

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            //todo какую фабрику?
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_DOTA_API_URL)
            .build()
    }

    private val dotaApi = retrofit.create(DotaApi::class.java)

    private val dotaRepository = DotaRepositoryImpl(dotaApi)

    val getMatchUseCase: GetMatchUseCase
        get() = GetMatchUseCase(dotaRepository)

    val searchPlayersUseCase: GetMatchUseCase
        get() = GetMatchUseCase(dotaRepository)


}
