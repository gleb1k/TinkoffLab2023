package com.example.tinkofflab2023.data

import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.domain.DotaRepository

class DotaRepositoryLocal(
    private val db: AppDatabase
) : DotaRepository {
    private val playerDao by lazy {
        db.getPlayerDao()
    }

    private val matchDao by lazy {
        db.getMatchDao()
    }
}
