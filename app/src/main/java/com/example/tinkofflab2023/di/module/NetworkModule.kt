package com.example.tinkofflab2023.di.module

import com.example.tinkofflab2023.core.util.jsonparser.GsonParser
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.remote.DotaApi
import com.google.gson.Gson
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    @Binds
    @Singleton
    fun

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_DOTA_API_URL)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit() {

    }


    private val api = retrofit.create(DotaApi::class.java)

    private val gsonParser = GsonParser(Gson())
}
