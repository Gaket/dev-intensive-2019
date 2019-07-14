package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Artur (gaket) on 2019-07-02.
 */

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dataFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dataFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time
    return this
}

//  0с - 1с "только что"
//
//  1с - 45с "несколько секунд назад"
//
//  45с - 75с "минуту назад"
//
//  75с - 45мин "N минут назад"
//
//  45мин - 75мин "час назад"
//
//  75мин 22ч "N часов назад"
//
//  22ч - 26ч "день назад"
//
//  26ч - 360д "N дней назад"
//
//  >360д "более года назад"
fun Date.humanizeDiff(): String {
    val time = this.time
    val diff = System.currentTimeMillis() - time
    return when (diff) {
        in 0..SECOND -> "только что"
        in SECOND..45 * SECOND -> "несколько секунд назад"
        in 45 * SECOND..75 * SECOND -> "минуту назад"
        in 75 * SECOND..45 * MINUTE -> "${diff / MINUTE} минут назад"
        in 45 * MINUTE..75 * MINUTE -> "час назад"
        in 75 * MINUTE..22 * HOUR -> "${diff / HOUR} часов назад"
        in 22 * HOUR..26 * HOUR -> "день назад"
        in 26 * HOUR..360 * DAY -> "${diff / DAY} дней назад"
        in 360 * DAY..Long.MAX_VALUE -> "более года назад"
        else -> ""
    }
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY
}