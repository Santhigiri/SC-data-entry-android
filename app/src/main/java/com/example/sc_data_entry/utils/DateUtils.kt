package com.example.sc_data_entry.utils

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

class AppDateUtils{
    companion object{
        fun convertMillisToLocalDate(millis: Long): LocalDate {
            return Instant.ofEpochMilli(millis)
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .plusDays(1)//TODO: FIX THIS Additional Day added as a hack


        }
    }
}