package com.example.sc_data_entry.components.buttons

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import components.buttons.IconButtonPrimary
import components.buttons.PrimaryButton


@Composable
fun NavigationDrawerButton(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    contentDescription : String? = null,
    label: String,
    onClick: () -> Unit,
){
        IconButton(
            onClick = onClick,
            modifier = modifier,
        ) {
           Row {
               Icon(icon, contentDescription)
               Text(text = label)
           } 
        }

}