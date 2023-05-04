package com.example.tinkofflab2023.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tinkofflab2023.data.local.dao.MatchDao
import com.example.tinkofflab2023.data.local.dao.PlayerDao
import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.local.entity.PlayerEntity

@Database(entities = [MatchEntity::class,PlayerEntity::class], version = 1)
//@TypeConverters(DateTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPlayerDao() : PlayerDao

    abstract fun getMatchDao() : MatchDao

}
