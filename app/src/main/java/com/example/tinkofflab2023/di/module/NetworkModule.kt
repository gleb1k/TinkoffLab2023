package com.example.tinkofflab2023.di.module

import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.remote.DotaApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

// todo object?
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(
        httpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(gsonConverterFactory)
            .baseUrl(Constants.BASE_DOTA_API_URL)
            .build()

    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideApi(
        retrofit: Retrofit
    ): DotaApi = retrofit.create(DotaApi::class.java)
}
