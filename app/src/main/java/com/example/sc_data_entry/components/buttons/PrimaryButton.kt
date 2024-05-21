package components.buttons

import androidx.compose.foundation.border
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.theme.shapes

@Composable
fun PrimaryButton(
    label: String,
   onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        shape = shapes.small
    ){
        Text(label)
    }
}