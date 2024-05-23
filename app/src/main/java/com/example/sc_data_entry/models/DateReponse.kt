package com.example.sc_data_entry.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Significance(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("type") val type: SignificanceType,
    @SerialName("description") val description: String,
)



enum class SignificanceType{
    CHOTHI,
    POURNAMI,
    POORNA_KUMBAMELA,
}
enum class PrayerTimeType{
    FIXED_PRAYER_TIME,
    VARIABLE_PRAYER_TIME,
    SPECIAL_PRAYER_TIME,
}

//@Serializable
//data class Prayer(
//    @SerialName("time") val time: String ,
//)

@Serializable
data class DateResponse(
    @SerialName("significances") val significances: List<Significance>,
    @SerialName("prayers") val prayers: List<String>,
)