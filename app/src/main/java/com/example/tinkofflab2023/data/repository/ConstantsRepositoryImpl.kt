package com.example.tinkofflab2023.data.repository

import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.entity.HeroEntity
import com.example.tinkofflab2023.data.local.entity.ItemEntity
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.remote.response.constants.heroes.toEntity
import com.example.tinkofflab2023.data.remote.response.constants.items.toEntity
import com.example.tinkofflab2023.domain.repository.ConstantsRepository
import timber.log.Timber
import javax.inject.Inject

class ConstantsRepositoryImpl @Inject constructor(
    private val db: AppDatabase,
    private val api: DotaApi
) : ConstantsRepository {

    private val heroDao = db.getHeroDao()

    private val itemDao = db.getItemDao()

    override suspend fun getHeroes(): List<HeroEntity> {
        val heroesFromDb = heroDao.getAll()
        return if (heroesFromDb.isNotEmpty())
            heroesFromDb
        else {
            try {
                val list = arrayListOf<HeroEntity>()
                api.getHeroes().forEach { entry ->
                    list.add(entry.value.toEntity())
                }
                heroDao.insertAll(list)
                list
            } catch (throwable: Throwable) {
                Timber.e(throwable)
                listOf()
            }
        }
    }

    override suspend fun getItems(): List<ItemEntity> {
        val itemsFromDb = itemDao.getAll()
        return if (itemsFromDb.isNotEmpty())
            itemsFromDb
        else {
            try {
                val list = arrayListOf<ItemEntity>()
                api.getItems().forEach { entry ->
                    list.add(entry.value.toEntity())
                }
                itemDao.insertAll(list)
                list
            } catch (throwable: Throwable) {
                Timber.e(throwable)
                listOf()
            }
        }
    }

}


