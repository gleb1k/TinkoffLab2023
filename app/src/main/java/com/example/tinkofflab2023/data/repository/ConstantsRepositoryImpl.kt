package com.example.tinkofflab2023.data.repository

import android.util.Log
import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.entity.HeroEntity
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.constants.toEntity
import com.example.tinkofflab2023.domain.repository.ConstantsRepository
import javax.inject.Inject

class ConstantsRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val api: DotaApi
) : ConstantsRepository {

    private val heroDao = db.getHeroDao()

    override suspend fun getHeroes(): List<HeroEntity> {
        val heroesFromDb = heroDao.getAll()
        if (heroesFromDb.isNotEmpty())
            return heroesFromDb
        else {
            try {
                val list = arrayListOf<HeroEntity>()
                api.getHeroes().forEach { entry ->
                    list.add(entry.value.toEntity())
                }
                heroDao.insertAll(list)
                return list
            } catch (throwable: Throwable) {
                Log.e("getHeroes error", throwable.message.toString())
                return listOf()
            }
        }
    }

}


