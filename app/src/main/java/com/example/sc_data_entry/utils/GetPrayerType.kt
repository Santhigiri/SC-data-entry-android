package com.example.sc_data_entry.utils

import com.example.sc_data_entry.models.PrayerTimeType
val fixedPrayerTimes = listOf(
    "00:00",
    "03:00",
    "09:00",
    "12:00",
    "15:00",
    "21:00"
)
fun getPrayerType(prayerTime : String): PrayerTimeType =
    when(prayerTime){
        in fixedPrayerTimes -> PrayerTimeType.FIXED_PRAYER_TIME
        else -> PrayerTimeType.VARIABLE_PRAYER_TIME
    }


