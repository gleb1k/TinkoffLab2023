package com.example.tinkofflab2023.di

import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.remote.DotaApi
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

     val dotaApi = retrofit.create(DotaApi::class.java)


}
