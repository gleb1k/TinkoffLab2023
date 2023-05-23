package com.example.tinkofflab2023.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinkofflab2023.data.local.entity.HeroEntity

@Dao
interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(hero: HeroEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(hero: List<HeroEntity>)

    @Query("SELECT * FROM heroes WHERE id=:id")
    suspend fun get(id: Int): HeroEntity?

    @Query("SELECT * FROM heroes")
    suspend fun getAll(): List<HeroEntity>

}
