package components.cards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import components.buttons.IconButtonPrimary

@Composable
fun VariablePrayerCard(
    prayerTime: String,
    prayerType: String? = "Variable Prayer",
    onEdit: () -> Unit,

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
            }
        )

    )
}