package com.example.tinkofflab2023.data.local.dao

import androidx.room.*
import com.example.tinkofflab2023.data.local.entity.PlayerEntity

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(player: PlayerEntity)

    @Query("SELECT * FROM players WHERE id=:id")
    suspend fun get(id: String): PlayerEntity?

    @Query("SELECT * FROM players")
    suspend fun getAll(): List<PlayerEntity>?

    @Query("SELECT COUNT(id) from players where isFavorite=${false}")
    suspend fun countCache() : Int

    @Query("DELETE FROM players WHERE isFavorite=${false}")
    suspend fun clearCache()

    @Query("UPDATE players SET isFavorite=${true} WHERE id=:id")
    suspend fun addToFavorite(id: String)

    @Query("UPDATE players SET isFavorite=${false} WHERE id=:id")
    suspend fun removeFromFavorite(id: String)

    @Query("SELECT isFavorite FROM players WHERE id=:id")
    suspend fun isFavorite(id: String): Boolean

    @Query("SELECT * FROM players WHERE isFavorite=${true}")
    suspend fun getFavorites(): List<PlayerEntity>?

//    @Query("SELECT players.heroes FROM players WHERE id=:id")
//    suspend fun getHeroes(id: String): PlayerHeroesResponse? List<heroResponse>
//
//    @Query("SELECT players.recentMatches FROM players WHERE id=:id")
//    suspend fun getRecentMatches(id: String): PlayerMatchesResponse?

    @Delete
    suspend fun delete(player: PlayerEntity)

    @Query("DELETE FROM players WHERE id=:id")
    suspend fun deleteById(id: String)

    @Update
    suspend fun update(player: PlayerEntity)
}
