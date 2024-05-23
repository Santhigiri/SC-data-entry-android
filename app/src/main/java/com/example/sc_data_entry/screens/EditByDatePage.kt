package com.example.sc_data_entry.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.VerticalDivider
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.sc_data_entry.components.PrayerGridView
import com.example.sc_data_entry.components.SignificancesListView
import com.example.sc_data_entry.state.AppState
import com.example.sc_data_entry.models.DateResponse
import com.example.sc_data_entry.state.AppActions
import com.example.sc_data_entry.state.addPrayerTimeThunk
import com.example.sc_data_entry.utils.AppDateUtils
import components.buttons.PrimaryButton
import org.reduxkotlin.compose.rememberDispatcher
import org.reduxkotlin.compose.selectState
import ui.theme.appTypography
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditByDatePage(

){
    val coroutineScope = rememberCoroutineScope()
    val isLoadingState by selectState<AppState,Boolean> {isLoading}
    val dispatch = rememberDispatcher()
    val selectedDate by selectState<AppState,LocalDate> {selectedDate}
    val dateResponse by selectState < AppState, DateResponse>{dateResponse}
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false)}
    val showAddSignificanceDialog by selectState<AppState,Boolean>{showAddSignificanceDialog}
    val showAddPrayerTimeDialog by selectState<AppState,Boolean>{showAddPrayerTimeDialog}
    if(isLoadingState){
        Dialog(onDismissRequest = { /*TODO*/ }) {
            CircularProgressIndicator()
        }}
    else if (showAddSignificanceDialog){
        SignificanceDialog(
            onDismissRequest = {
                dispatch(AppActions.HideSignificanceDialog)
            },
            onConfirmRequest = {}
        )
    }
    else if(showAddPrayerTimeDialog){
        prayerTimeDialog()
    }
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 8.dp),
            ) {
                Text(
                    text = "Santhigiri Calendar",
                    style = appTypography.headlineSmall
                )

                Row {
                    IconButton(onClick = {
                        dispatch(AppActions.ChangeDate(selectedDate = selectedDate.minusDays(1)))
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,contentDescription = "Previous Date")
                    }

                    TextField(
                        value = selectedDate.toString(),
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = {
                            IconButton(onClick = {
                                showDatePicker = true
                            }) {
                                Icon(imageVector = Icons.Default.DateRange, contentDescription = "Select Date")
                            }
                        }
                    )

                    if (showDatePicker){
                        DatePickerDialog(
                            onDismissRequest = {showDatePicker = false},
                            dismissButton = {
                                TextButton(onClick = {
                                    showDatePicker = false
                                }) {
                                    Text("Cancel")
                                }
                            },
                            confirmButton = {
                                TextButton(onClick = {
                                    val selectedDateFormatted = datePickerState.selectedDateMillis?.let {
                                        AppDateUtils.convertMillisToLocalDate(it)
                                    }
                                    dispatch(AppActions.ChangeDate(selectedDate = selectedDateFormatted ?: LocalDate.now()))
                                    showDatePicker = false
                                }) {
                                    Text(text = "Confirm")
                                }}) {
                            DatePicker(state = datePickerState)
                        }
                    }

                    IconButton(onClick = {
                        dispatch(AppActions.ChangeDate(selectedDate = selectedDate.plusDays(1)))
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,contentDescription = "Next Date")
                    }
                    PrimaryButton(
                        label = "Update",
                        onClick = {
                            dispatch(addPrayerTimeThunk(coroutineScope = coroutineScope,prayerTime = "06:20"))
                        }
                    ) }
            }
            Column(
                modifier =  Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                if (dateResponse == null){
                    Text(text = "No data to show")
                }else{
                    Row (
                        modifier = Modifier.fillMaxSize(),
                    ){
                        SignificancesListView(significances = dateResponse.significances)
                        VerticalDivider()
                        PrayerGridView(prayers = dateResponse.prayers)
                    }

                }
            }
        }

}

