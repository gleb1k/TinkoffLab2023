package com.example.tinkofflab2023.data.local

import androidx.room.*
import com.example.tinkofflab2023.data.local.entity.MatchEntity
import com.example.tinkofflab2023.data.local.entity.PlayerEntity

@Dao
interface MatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(match: MatchEntity)

    @Delete
    suspend fun delete(match: MatchEntity)

    //Если не находит возвращает NULL
    @Query("SELECT * FROM matches WHERE id=:id")
    suspend fun get(id: String): MatchEntity

    @Query("DELETE FROM matches")
    suspend fun deleteAll()

    @Update
    suspend fun update(match: MatchEntity)

}
