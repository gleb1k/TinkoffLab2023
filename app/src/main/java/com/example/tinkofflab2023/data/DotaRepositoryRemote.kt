package com.example.tinkofflab2023.data

import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.domain.DotaRepository

class DotaRepositoryRemote(
    private val api: DotaApi
) : DotaRepository {

}
