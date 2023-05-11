package com.example.tinkofflab2023.di.module

import android.content.Context
import androidx.room.Room
import com.example.tinkofflab2023.core.util.jsonparser.GsonParser
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.converter.MatchConverter
import com.example.tinkofflab2023.data.local.converter.PlayerConverter
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    //todo Singleton?
    @Provides
    @Singleton
    fun provideGsonParser(
        gson: Gson
    ): GsonParser = GsonParser(gson)

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    fun providePlayerConverter(
        gsonParser: GsonParser
    ): PlayerConverter = PlayerConverter(gsonParser)

    @Provides
    fun provideMatchConverter(
        gsonParser: GsonParser
    ): MatchConverter = MatchConverter(gsonParser)

    @Provides
    @Singleton
    fun provideAppDataBase(
        @ApplicationContext context: Context,
        playerConverter: PlayerConverter,
        matchConverter: MatchConverter
    ): AppDatabase =
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            //todo constants?
            Constants.DOTA_DATABASE_NAME
        )
            .addTypeConverter(playerConverter)
            .addTypeConverter(matchConverter)
            //TODO почему когда добавляю его сюда то выкидываает ошибку? ну сделать через хилт если еще
            //.addTypeConverter(BaseConverter(gsonParser))
            .fallbackToDestructiveMigration()
            .build()
}
