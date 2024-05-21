package components.cards

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.buttons.IconButtonPrimary

@Composable
fun SignificanceListItem(
    labelText: String,
    secondaryText: String? = null,
    onDelete: () -> Unit
){
    CardPrimary (
        headline = labelText,
        subhead = secondaryText,
        actions = mutableListOf<@Composable()()-> Unit>(
            {
                IconButtonPrimary(
                    icon = Icons.Filled.Delete,
                    onClick = onDelete
                )
            }
        )
    )
}