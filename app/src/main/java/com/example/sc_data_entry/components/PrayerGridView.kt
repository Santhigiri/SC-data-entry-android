package com.example.sc_data_entry.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sc_data_entry.models.PrayerTimeType
import com.example.sc_data_entry.utils.getPrayerType
import components.cards.FixedPrayerCard
import components.cards.SpecialPrayerCard
import components.cards.VariablePrayerCard

@Composable
fun PrayerGridView(prayers: List<String>){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(1f),
        columns = GridCells.Fixed(2),
    ) {
        itemsIndexed(prayers) { _, item ->
            val prayerTimeType: PrayerTimeType = getPrayerType(item)
            when (prayerTimeType) {
                PrayerTimeType.FIXED_PRAYER_TIME -> FixedPrayerCard(
                    prayerTime = item
                )

                PrayerTimeType.VARIABLE_PRAYER_TIME -> VariablePrayerCard(
                    prayerTime = item,
                    onEdit = {})

                PrayerTimeType.SPECIAL_PRAYER_TIME -> SpecialPrayerCard(
                    prayerTime = item,
                    onEdit = {},
                    onDelete = {})
            }
        }
    }
}