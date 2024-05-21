package components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun IconButtonPrimary(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription :String? = null

){
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ){
       Icon(
           icon,
           contentDescription = contentDescription
       )
    }
}