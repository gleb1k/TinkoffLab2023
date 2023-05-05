package com.example.tinkofflab2023.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.tinkofflab2023.core.utils.jsonparser.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class HeroConverter(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun toRolesJson(roles: List<String>): String {
        return jsonParser.toJson(
            roles,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromRolesJson(json: String): List<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: emptyList()
    }
}
