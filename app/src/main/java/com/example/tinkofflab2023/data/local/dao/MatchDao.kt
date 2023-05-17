package com.example.tinkofflab2023.data.local.dao

import androidx.room.*
import com.example.tinkofflab2023.data.local.entity.MatchEntity

@Dao
interface MatchDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(match: MatchEntity)

    @Query("SELECT * FROM matches WHERE id=:id")
    suspend fun get(id: String): MatchEntity?

    @Query("SELECT COUNT(id) from matches where isFavorite=${false}")
    suspend fun countCache(): Int

    @Query("DELETE FROM matches WHERE isFavorite=${false}")
    suspend fun clearCache()

    @Query("UPDATE matches SET isFavorite=${true} WHERE id=:id")
    suspend fun addToFavorite(id: String)

    @Query("UPDATE matches SET isFavorite=${false} WHERE id=:id")
    suspend fun removeFromFavorite(id: String)

    @Query("SELECT isFavorite FROM matches WHERE id=:id")
    suspend fun isFavorite(id: String): Boolean?

    @Query("SELECT * FROM matches WHERE isFavorite=${true}")
    suspend fun getFavorites(): List<MatchEntity>?

    @Query("DELETE FROM matches WHERE id=:id")
    suspend fun deleteById(id: String)

    @Delete
    suspend fun delete(match: MatchEntity)

    @Query("DELETE FROM matches")
    suspend fun deleteAll()

    @Update
    suspend fun update(match: MatchEntity)

}
