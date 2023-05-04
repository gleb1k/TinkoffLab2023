package com.example.tinkofflab2023.data.local.converter

import androidx.room.TypeConverter
import com.example.tinkofflab2023.data.remote.response.players.data.MmrEstimate
import com.google.gson.Gson

class PlayerConverter {
    @TypeConverter
    fun fromMmrEstimate(mmr: MmrEstimate) : Int = mmr.estimate

    @TypeConverter
    fun toMmrEstimate(estimate: Int): MmrEstimate = MmrEstimate(estimate)

    @TypeConverter
    fun

//    @TypeConverter
//    fun fromTimestamp(value: Long?): Date? {
//        return if (value == null) null else Date(value)
//    }
//
//    @TypeConverter
//    fun dateToTimestamp(date: Date?): Long? {
//        return date?.time
//    }
}
