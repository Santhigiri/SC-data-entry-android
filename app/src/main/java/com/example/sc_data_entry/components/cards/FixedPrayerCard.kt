package components.cards

import androidx.compose.runtime.Composable

@Composable
fun FixedPrayerCard(
    prayerTime: String,
    prayerType: String? = "Fixed Prayer"
){
    CardPrimary(
        headline = prayerTime,
        subhead = prayerType
    )
}