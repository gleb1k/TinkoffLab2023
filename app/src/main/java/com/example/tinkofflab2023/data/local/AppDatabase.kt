package com.example.tinkofflab2023.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tinkofflab2023.data.local.converter.BaseConverter
import com.example.tinkofflab2023.data.local.dao.HeroDao
import com.example.tinkofflab2023.data.local.dao.MatchDao
import com.example.tinkofflab2023.data.local.dao.PlayerDao
import com.example.tinkofflab2023.data.local.entity.HeroEntity
import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.local.entity.PlayerEntity

@Database(
    version = 4,
    entities = [MatchEntity::class, PlayerEntity::class, HeroEntity::class],
)
@TypeConverters(BaseConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPlayerDao(): PlayerDao

    abstract fun getMatchDao(): MatchDao

    abstract fun getHeroDao(): HeroDao
}
