package com.example.tinkofflab2023.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tinkofflab2023.core.App
import com.example.tinkofflab2023.core.utils.jsonparser.GsonParser
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.local.converter.HeroConverter
import com.example.tinkofflab2023.data.local.converter.MatchConverter
import com.example.tinkofflab2023.data.local.converter.PlayerConverter
import com.example.tinkofflab2023.data.local.dao.MatchDao
import com.example.tinkofflab2023.data.local.dao.PlayerDao
import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.response.constants.heroes.HeroResponse
import com.example.tinkofflab2023.di.DataContainer
import com.google.gson.Gson

@Database(entities = [MatchEntity::class, PlayerEntity::class, HeroResponse::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPlayerDao(): PlayerDao

    abstract fun getMatchDao(): MatchDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (instance == null) {

                val gsonParser = GsonParser(Gson())

                synchronized(AppDatabase::class.java) {
                    instance = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        Constants.DOTA_DATABASE_NAME
                    )
                        .addTypeConverter(PlayerConverter(gsonParser))
                        .addTypeConverter(MatchConverter(gsonParser))
                        .addTypeConverter(HeroConverter(gsonParser))
                        .build()
                }
            }
            return instance
        }
    }
}
