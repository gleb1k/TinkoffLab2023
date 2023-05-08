package com.example.tinkofflab2023.data.local.dao

import androidx.room.*
import com.example.tinkofflab2023.data.local.entity.PlayerEntity
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(player: PlayerEntity)

    @Query("SELECT * FROM players WHERE id=:id")
    suspend fun get(id: String): PlayerEntity?

    @Query("SELECT * FROM players")
    suspend fun getAll(): List<PlayerEntity>?

//    @Query("SELECT players.heroes FROM players WHERE id=:id")
//    suspend fun getHeroes(id: String): PlayerHeroesResponse?
//
//    @Query("SELECT players.recentMatches FROM players WHERE id=:id")
//    suspend fun getRecentMatches(id: String): PlayerMatchesResponse?

    @Delete
    suspend fun delete(player: PlayerEntity)

    @Query("DELETE FROM players WHERE id=:id")
    suspend fun deleteById(id: String)

    @Query("DELETE FROM players")
    suspend fun deleteAll()

    @Update
    suspend fun update(player: PlayerEntity)
}
