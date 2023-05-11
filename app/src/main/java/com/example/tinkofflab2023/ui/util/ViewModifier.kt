package com.example.tinkofflab2023.ui.util

import android.content.Context
import android.icu.text.SimpleDateFormat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.tinkofflab2023.R
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.Date
import java.util.Locale
import kotlin.math.roundToInt

class ViewModifier(
    @ApplicationContext private val context: Context
) {

    /**
     *  wins: 598; losses: 569 returns -> winrate: 51.2 %
     */
    fun winrate(wins: Int?, losses: Int?): String {
        try {
            if (wins == null || losses == null)
                return "-"
            val resultDouble = wins.toDouble() / (wins.toDouble() + losses.toDouble())
            return "${((resultDouble * 1000.0).roundToInt().toDouble() / 10.0)} %"
        } catch (thr: Throwable) {
            return "-"
        }
    }

    fun wl(wins: Int?, losses: Int?): String {
        if (wins == null || losses == null)
            return "-"
        return "$wins/$losses"
    }

    /**
     *  2023-03-13T14:24:58.892Z returns -> 13.03.2023
     */
    fun toDate(time: String?): String {
        if (time == null)
            return "-"
        return try {
            val year = time.take(4)
            val month = time.substring(5, 7)
            val day = time.substring(8, 10)
            "$day.$month.$year"
        } catch (ex: Throwable) {
            "-"
        }
    }

    fun winSide(radiantWin: Boolean): String {
        return if (radiantWin)
            context.getString(R.string.radiant_victory)
        else
            context.getString(R.string.dire_victory)
    }

    /**
     *  Match duration 1471 seconds returns -> 24:31
     */
    fun matchDuration(totalSecs: Int?): String {
        if (totalSecs == null)
            return "-"

        val hours = totalSecs / 3600
        val minutes = (totalSecs % 3600) / 60
        val seconds = totalSecs % 60

        return if (hours != 0)
            String.format("%02d:%02d:%02d", hours, minutes, seconds)
        else
            String.format("%02d:%02d", minutes, seconds)
    }

    fun kda(kills: Int, deaths: Int, assists: Int): String =
        "$kills/$deaths/$assists"

    fun epochToDate(totalSecs: String?): String {
        if (totalSecs == null)
            return "-"
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val netDate = Date(totalSecs.toLong() * 1000)
        return sdf.format(netDate)
    }

    //todo
    fun lostOrWonMatch(playerSlot: Int, radiantWin: Boolean): String {
        //0-127 are Radiant, 128-255 are Dire
        if (playerSlot in 0..127 && radiantWin)
            return context.getString(R.string.won_match)
        if (playerSlot in 0..127 && !radiantWin)
            return context.getString(R.string.lost_match)
        if (playerSlot in 128..255 && radiantWin)
            return context.getString(R.string.lost_match)
        if (playerSlot in 128..255 && !radiantWin)
            return context.getString(R.string.won_match)
        return "-"
    }

    fun getCircularProgressDrawable(): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        return circularProgressDrawable
    }

}
