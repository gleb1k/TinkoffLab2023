package com.example.tinkofflab2023.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.tinkofflab2023.core.utils.jsonparser.JsonParser
import com.example.tinkofflab2023.data.remote.response.matches.MatchResponse
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class MatchConverter(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun toMatchResponseJson(data: MatchResponse): String {
        return jsonParser.toJson(
            data,
            object : TypeToken<MatchResponse>() {}.type
        ) ?: ""
    }

    @TypeConverter
    fun fromMatchResponseJson(json: String): MatchResponse? {
        return jsonParser.fromJson<MatchResponse>(
            json,
            object : TypeToken<MatchResponse>() {}.type
        )
    }
}
