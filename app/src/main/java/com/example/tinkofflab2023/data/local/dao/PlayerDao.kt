package com.example.tinkofflab2023.data.local.dao

import androidx.room.*
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(player: PlayerEntity)

    @Query("SELECT * FROM players WHERE id=:id")
    fun get(id: String): Flow<PlayerEntity>

    @Query("SELECT * FROM players")
    fun getAll(): Flow<List<PlayerEntity>>

    @Delete
    suspend fun delete(player: PlayerEntity)

    @Query("DELETE FROM players WHERE id=:id")
    suspend fun deleteById(id: String)

    @Query("DELETE FROM players")
    suspend fun deleteAll()

    @Update
    suspend fun update(player: PlayerEntity)
}



