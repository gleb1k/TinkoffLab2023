package com.example.tinkofflab2023.data.local

import androidx.room.*
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.response.matches.Player
import java.nio.charset.CodingErrorAction.REPLACE


@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(player: PlayerEntity)

    @Delete
    suspend fun delete(player: PlayerEntity)

    //Если не находит возвращает NULL
    @Query("SELECT * FROM players WHERE id=:id")
    suspend fun get(id: String): PlayerEntity

    @Query("DELETE FROM players")
    suspend fun deleteAll()

    @Update
    suspend fun update(player: PlayerEntity)
}


