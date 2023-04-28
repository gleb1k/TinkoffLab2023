package com.example.tinkofflab2023.utils

import android.icu.text.SimpleDateFormat
import android.os.Build
import java.util.*
import kotlin.math.roundToInt

object Converter {

    /**
     *  wins: 598; losses: 569 returns -> winrate: 51.2 %
     */
    fun winrate(wins: Int, losses: Int): String {
        val resultDouble = wins.toDouble() / (wins.toDouble() + losses.toDouble())
        return "${((resultDouble * 1000.0).roundToInt().toDouble() / 10.0)} %"
    }

    fun wl(wins: Int, losses: Int) : String {
        return "$wins/$losses"
    }

    /**
     *  2023-03-13T14:24:58.892Z returns -> 13.03.2023
     */
    //todo непонятно какой часовой пояс, дата может отставать
    fun toDate(time: String?): String {
        if (time == null)
            return "-"
        val year = time.take(4)
        val month = time.substring(5, 7)
        val day = time.substring(8, 10)
        return "$day.$month.$year"
    }

    fun winSide(radiantWin: Boolean): String {
        return if (radiantWin)
            "Radiant Victory"
        else
            "Dire Victory"
    }

    /**
     *  Match duration 1471 seconds returns -> 24:31
     */
    fun matchDuration(totalSecs: Int): String {
        val hours = totalSecs / 3600
        val minutes = (totalSecs % 3600) / 60
        val seconds = totalSecs % 60

        return if (hours != 0)
            String.format("%02d:%02d:%02d", hours, minutes, seconds)
        else
            String.format("%02d:%02d", minutes, seconds)
    }

    fun kda(kills:Int, deaths: Int, assists: Int) : String =
        "$kills/$deaths/$assists"

    //todo ? epoch -> date по-человечески
    fun epochToDate(totalSecs: String): String {
        val sdf = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            SimpleDateFormat("dd/MM/yyyy")
        } else {
            TODO("VERSION.SDK_INT < N")
        }
        val netDate = Date(totalSecs.toLong() * 1000)
        return sdf.format(netDate)
    }

    fun lostOrWonMatch(playerSlot: Int, radiantWin: Boolean) : String {
        //0-127 are Radiant, 128-255 are Dire
        if (playerSlot in 0..127 && radiantWin)
            return "Won Match"
        if (playerSlot in 0..127 && !radiantWin)
            return "Lost Match"
        if (playerSlot in 128..255 && radiantWin)
            return "Lost Match"
        if (playerSlot in 128..255 && !radiantWin)
            return "Won Match"
        return ""

    }

}
