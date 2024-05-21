package components.cards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import components.buttons.IconButtonPrimary


@Composable
fun SignificantDateCard(
    date: String,
    onDelete: () -> Unit,
){
    CardPrimary(
        headline = date,
        actions = mutableListOf(
            {
                IconButtonPrimary(
                    icon = Icons.Filled.Delete,
                    onClick = onDelete,
                )
            }
        )
    )
}