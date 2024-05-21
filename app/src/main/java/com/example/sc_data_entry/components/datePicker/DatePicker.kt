package components.datePicker

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerPrimary(
    value: String,
    modifier: Modifier = Modifier
){
    TextField(
        value = value,
        onValueChange = {
            //TODO: Implement validation
        }
    )

}