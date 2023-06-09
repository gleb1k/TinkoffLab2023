package com.example.tinkofflab2023.data.local.converter

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.tinkofflab2023.core.util.jsonparser.JsonParser
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class BaseConverter(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun toListJson(list: ArrayList<String>): String {
        return jsonParser.toJson(
            list,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromListJson(json: String): ArrayList<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<ArrayList<String>>() {}.type
        ) ?: arrayListOf()
    }
}
