package com.example.sc_data_entry.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import com.example.sc_data_entry.models.SignificanceType
import com.example.sc_data_entry.state.AppActions
import components.buttons.PrimaryButton
import org.reduxkotlin.compose.rememberDispatcher

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignificanceDialog(
    onDismissRequest: () -> Unit,
    onConfirmRequest: () -> Unit,
){
    var expanded by remember { mutableStateOf(false)}
    val dispatch = rememberDispatcher()
    var selectedSignificanceType by remember { mutableStateOf(SignificanceType.POURNAMI)}
    Dialog(onDismissRequest = {onDismissRequest}) {
        Card (
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth(),

        ){
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly,
            ) {
                Text(text = "Add new Significance Dialog")
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    TextField(
                        value = selectedSignificanceType.name,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)},
                        modifier = Modifier.menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {

                        SignificanceType.values().forEach {
                            DropdownMenuItem(
                                text = { Text(text = it.name) },
                                onClick = {
                                    selectedSignificanceType = it
                                    expanded = false
                                }
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    PrimaryButton(
                        label = "Dismiss",
                        onClick = onDismissRequest,
                    )
                    PrimaryButton(
                        label = "Confirm",
                        onClick = {
                            dispatch(AppActions.AddSignificance(significanceType = selectedSignificanceType))
                            onDismissRequest()
                        },
                    )
                }
            }
        }
    }
}


