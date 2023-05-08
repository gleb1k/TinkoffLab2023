package com.example.tinkofflab2023.di

import androidx.room.Room
import com.example.tinkofflab2023.core.App
import com.example.tinkofflab2023.core.util.jsonparser.GsonParser
import com.example.tinkofflab2023.data.Constants
import com.example.tinkofflab2023.data.local.AppDatabase
import com.example.tinkofflab2023.data.local.converter.BaseConverter
import com.example.tinkofflab2023.data.local.converter.MatchConverter
import com.example.tinkofflab2023.data.local.converter.PlayerConverter
import com.example.tinkofflab2023.data.remote.DotaApi
import com.example.tinkofflab2023.data.repository.ConstantsRepositoryImpl
import com.example.tinkofflab2023.data.repository.MatchRepositoryImpl
import com.example.tinkofflab2023.data.repository.PlayerRepositoryImpl
import com.example.tinkofflab2023.data.repository.SearchRepositoryImpl
import com.example.tinkofflab2023.domain.usecase.GetMatchModelUseCase
import com.example.tinkofflab2023.domain.usecase.GetMatchUseCase
import com.example.tinkofflab2023.domain.usecase.GetPlayerHeroesUseCase
import com.example.tinkofflab2023.domain.usecase.GetPlayerMatchesUseCase
import com.example.tinkofflab2023.domain.usecase.GetPlayerModelUseCase
import com.example.tinkofflab2023.domain.usecase.SearchPlayersUseCase
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//временная мера, потом будет Dagger,                  или нет
object DataContainer {

    private val httpClient by lazy {
        OkHttpClient.Builder()
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_DOTA_API_URL)
            .build()
    }

    private val api = retrofit.create(DotaApi::class.java)

    private val gsonParser = GsonParser(Gson())
    private val db =
        Room.databaseBuilder(App.context(), AppDatabase::class.java, Constants.DOTA_DATABASE_NAME)
            .addTypeConverter(PlayerConverter(gsonParser))
            .addTypeConverter(MatchConverter(gsonParser))
                //TODO почему когда добавляю его сюда то выкидываает ошибку?
            //.addTypeConverter(BaseConverter(gsonParser))
            .fallbackToDestructiveMigration()
            .build()

    private val matchRepositoryImpl = MatchRepositoryImpl(db, api)

    private val playerRepositoryImpl = PlayerRepositoryImpl(db, api)

    private val constantsRepository = ConstantsRepositoryImpl(db, api)

    val getPlayerModelUseCase: GetPlayerModelUseCase
        get() = GetPlayerModelUseCase(playerRepositoryImpl, constantsRepository)

    val getMatchModelUseCase: GetMatchModelUseCase
        get() = GetMatchModelUseCase(matchRepositoryImpl, constantsRepository)

    val getPlayerHeroesUseCase: GetPlayerHeroesUseCase
        get() = GetPlayerHeroesUseCase(playerRepositoryImpl, constantsRepository)

    val getPlayerMatchesUseCase: GetPlayerMatchesUseCase
        get() = GetPlayerMatchesUseCase(playerRepositoryImpl, constantsRepository)

    private val searchRepository = SearchRepositoryImpl(api)

    val getMatchUseCase: GetMatchUseCase
        get() = GetMatchUseCase(searchRepository)

    val searchPlayersUseCase: SearchPlayersUseCase
        get() = SearchPlayersUseCase(searchRepository)

}
