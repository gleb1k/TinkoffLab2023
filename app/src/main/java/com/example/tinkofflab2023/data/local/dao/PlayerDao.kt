package com.example.tinkofflab2023.data.local.dao

import androidx.room.*
import com.example.tinkofflab2023.data.local.entity.PlayerEntity


@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(player: PlayerEntity)

    @Delete
    suspend fun delete(player: PlayerEntity)

    @Query("SELECT * FROM players WHERE id=:id")
    suspend fun get(id: String): PlayerEntity

    @Query("DELETE FROM players")
    suspend fun deleteAll()

    @Update
    suspend fun update(player: PlayerEntity)
}


