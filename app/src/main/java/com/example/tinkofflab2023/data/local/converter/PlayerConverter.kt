package com.example.tinkofflab2023.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.tinkofflab2023.core.util.jsonparser.JsonParser
import com.example.tinkofflab2023.data.remote.response.players.data.PlayerDataResponse
import com.example.tinkofflab2023.data.remote.response.players.data.Profile
import com.example.tinkofflab2023.data.remote.response.players.heroes.PlayerHeroesResponse
import com.example.tinkofflab2023.data.remote.response.players.matches.PlayerMatchesResponse
import com.example.tinkofflab2023.data.remote.response.players.wl.PlayerWLResponse
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class PlayerConverter(
    private val jsonParser: JsonParser
) {

//    @TypeConverter
//    fun fromMmrEstimate(mmr: MmrEstimate): Int = mmr.estimate
//
//    @TypeConverter
//    fun toMmrEstimate(estimate: Int): MmrEstimate = MmrEstimate(estimate)

    @TypeConverter
    fun toDataResponseJson(data: PlayerDataResponse): String {
        return jsonParser.toJson(
            data,
            object : TypeToken<PlayerDataResponse>() {}.type
        ) ?: ""
    }

    @TypeConverter
    fun fromDataResponseJson(json: String): PlayerDataResponse? {
        return jsonParser.fromJson<PlayerDataResponse>(
            json,
            object : TypeToken<PlayerDataResponse>() {}.type
        )
    }

    @TypeConverter
    fun toProfileJson(profile: Profile): String {
        return jsonParser.toJson(
            profile,
            object : TypeToken<Profile>() {}.type
        ) ?: ""
    }

    @TypeConverter
    fun fromProfileJson(json: String): Profile? {
        return jsonParser.fromJson<Profile>(
            json,
            object : TypeToken<Profile>() {}.type
        )
    }

    @TypeConverter
    fun toWLResponseJson(wl: PlayerWLResponse): String {
        return jsonParser.toJson(
            wl,
            object : TypeToken<PlayerWLResponse>() {}.type
        ) ?: ""
    }

    @TypeConverter
    fun fromWLResponseJson(json: String): PlayerWLResponse? {
        return jsonParser.fromJson<PlayerWLResponse>(
            json,
            object : TypeToken<PlayerWLResponse>() {}.type
        )
    }


    @TypeConverter
    fun toHeroesResponseJson(heroes: PlayerHeroesResponse): String {
        return jsonParser.toJson(
            heroes,
            object : TypeToken<PlayerHeroesResponse>() {}.type
        ) ?: ""
    }

    @TypeConverter
    fun fromHeroesResponseJson(json: String): PlayerHeroesResponse? {
        return jsonParser.fromJson<PlayerHeroesResponse>(
            json,
            object : TypeToken<PlayerHeroesResponse>() {}.type
        )
    }

    @TypeConverter
    fun toMatchesResponseJson(matches: PlayerMatchesResponse): String {
        return jsonParser.toJson(
            matches,
            object : TypeToken<PlayerMatchesResponse>() {}.type
        ) ?: ""
    }

    @TypeConverter
    fun fromMatchesResponseJson(json: String): PlayerMatchesResponse? {
        return jsonParser.fromJson<PlayerMatchesResponse>(
            json,
            object : TypeToken<PlayerMatchesResponse>() {}.type
        )
    }

//    @TypeConverter
//    fun toMatchResponseJson(matches: List<PlayerMatchResponse>): String {
//        return jsonParser.toJson(
//            matches,
//            object : TypeToken<ArrayList<PlayerMatchResponse>>() {}.type
//        ) ?: "[]"
//    }
//
//    @TypeConverter
//    fun fromMatchResponseJson(json: String): List<PlayerMatchResponse> {
//        return jsonParser.fromJson<ArrayList<PlayerMatchResponse>>(
//            json,
//            object : TypeToken<ArrayList<PlayerMatchResponse>>() {}.type
//        ) ?: emptyList()
//    }
//
//    @TypeConverter
//    fun toHeroResponseJson(meaning: List<PlayerHeroResponse>): String {
//        return jsonParser.toJson(
//            meaning,
//            object : TypeToken<ArrayList<PlayerHeroResponse>>() {}.type
//        ) ?: "[]"
//    }
//
//    @TypeConverter
//    fun fromHeroResponseJson(json: String): List<PlayerHeroResponse> {
//        return jsonParser.fromJson<ArrayList<PlayerHeroResponse>>(
//            json,
//            object : TypeToken<ArrayList<PlayerHeroResponse>>() {}.type
//        ) ?: emptyList()
//    }
}
