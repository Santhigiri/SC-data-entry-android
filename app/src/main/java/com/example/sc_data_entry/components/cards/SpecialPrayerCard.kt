package components.cards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import components.buttons.IconButtonPrimary

@Composable
fun SpecialPrayerCard(
    prayerTime: String,
    prayerType: String? = "Special Prayer",
    onEdit: () -> Unit,
    onDelete: () -> Unit,

    ){
    CardPrimary(
        headline = prayerTime,
        subhead = prayerType,
        actions = mutableListOf<@Composable()() -> Unit>(
            {
                IconButtonPrimary(
                    onClick = onEdit,
                    icon = Icons.Filled.Edit
                )
                IconButtonPrimary(
                    onClick = onDelete,
                    icon = Icons.Filled.Delete
                )
            }
        )

    )
}