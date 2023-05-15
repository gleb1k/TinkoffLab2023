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
import com.example.tinkofflab2023.data.local.entity.PlayerData
import com.example.tinkofflab2023.data.local.entity.PlayerHeroEntity
import com.example.tinkofflab2023.data.local.entity.PlayerMatchEntity

@Database(
    version = 6,
    entities = [MatchEntity::class, PlayerData::class, HeroEntity::class, PlayerMatchEntity::class, PlayerHeroEntity::class ],
)
@TypeConverters(BaseConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPlayerDao(): PlayerDao

    abstract fun getMatchDao(): MatchDao

    abstract fun getHeroDao(): HeroDao
}
