package com.example.tinkofflab2023.di.module

import com.example.tinkofflab2023.data.repository.ConstantsRepositoryImpl
import com.example.tinkofflab2023.data.repository.MatchRepositoryImpl
import com.example.tinkofflab2023.data.repository.PlayerRepositoryImpl
import com.example.tinkofflab2023.data.repository.SearchRepositoryImpl
import com.example.tinkofflab2023.domain.repository.ConstantsRepository
import com.example.tinkofflab2023.domain.repository.MatchRepository
import com.example.tinkofflab2023.domain.repository.PlayerRepository
import com.example.tinkofflab2023.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMatchRepository(
        matchRepositoryImpl: MatchRepositoryImpl
    ): MatchRepository

    @Binds
    @Singleton
    abstract fun bindPlayerRepository(
        playerRepositoryImpl: PlayerRepositoryImpl
    ): PlayerRepository

    @Binds
    @Singleton
    abstract fun bindConstantsRepository(
        constantsRepositoryImpl: ConstantsRepositoryImpl
    ): ConstantsRepository

    @Binds
    @Singleton
    abstract fun bindSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository
    //todo singleton usecases?
}
