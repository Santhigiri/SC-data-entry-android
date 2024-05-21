package components.cards

import androidx.compose.runtime.Composable
import com.example.sc_data_entry.models.PrayerTimeType

@Composable
fun FixedPrayerCard(
    prayerTime: String,
    prayerType: String = "Fixed Prayer"
){
    CardPrimary(
        headline = prayerTime,
        subhead = prayerType
    )
}