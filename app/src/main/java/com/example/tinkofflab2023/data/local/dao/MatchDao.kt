package com.example.tinkofflab2023.data.local.dao

import androidx.room.*
import com.example.tinkofflab2023.data.local.entity.MatchEntity

@Dao
interface MatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(match: MatchEntity)

    @Delete
    suspend fun delete(match: MatchEntity)

    @Query("SELECT * FROM matches WHERE id=:id")
    suspend fun get(id: String): MatchEntity?

    @Query("DELETE FROM matches")
    suspend fun deleteAll()

    @Update
    suspend fun update(match: MatchEntity)

}
