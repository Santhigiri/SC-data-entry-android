package com.example.sc_data_entry.screens

import android.text.format.DateUtils
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sc_data_entry.state.AppState
import com.example.sc_data_entry.utils.getPrayerType
import components.cards.FixedPrayerCard
import components.cards.SignificanceListItem
import com.example.sc_data_entry.models.DateResponse
import com.example.sc_data_entry.models.PrayerTimeType
import com.example.sc_data_entry.models.Significance
import com.example.sc_data_entry.state.AppActions
import com.example.sc_data_entry.utils.AppDateUtils
import components.buttons.PrimaryButton
import components.cards.SpecialPrayerCard
import components.cards.VariablePrayerCard
import org.reduxkotlin.compose.rememberDispatcher
import org.reduxkotlin.compose.selectState
import ui.theme.appTypography
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditByDatePage(

){
    val dispatch = rememberDispatcher()
    val selectedDate by selectState<AppState,LocalDate> {selectedDate}
    val dateResponse by selectState < AppState, DateResponse>{dateResponse}
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false)}
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
        ) {
            Text(
                text = "Santhigiri Calendar",
                style = appTypography.headlineSmall
            )

            Row {
                IconButton(onClick = {
                  dispatch(AppActions.ChangeDate(selectedDate = selectedDate.minusDays(1)))
                }) {
                   Icon(imageVector = Icons.Default.KeyboardArrowLeft,contentDescription = "Previous Date")
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
                   Icon(imageVector = Icons.Default.KeyboardArrowRight,contentDescription = "Next Date")
                }
                PrimaryButton(label = "Update") {
                    
                }

            }
//
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
        }}
}


@Composable
fun SignificancesListView(significances: List<Significance>){
   LazyColumn (
       modifier = Modifier.fillMaxWidth(0.5f),
   ){
       items(significances.size){index ->
           SignificanceListItem(labelText = significances[index].name){}
               
       }
   }
}

@Composable
fun PrayerGridView(prayers: List<String>){
    LazyVerticalGrid(
        modifier = Modifier.fillMaxWidth(1f),
        columns = GridCells.Fixed(2),
    ) {
        itemsIndexed(prayers){ _, item ->
            val prayerTimeType: PrayerTimeType = getPrayerType(item)
            when(prayerTimeType){
                PrayerTimeType.FIXED_PRAYER_TIME -> FixedPrayerCard(
                   prayerTime = item)

                PrayerTimeType.VARIABLE_PRAYER_TIME -> VariablePrayerCard(
                    prayerTime = item,
                    onEdit ={})

                PrayerTimeType.SPECIAL_PRAYER_TIME -> SpecialPrayerCard(
                    prayerTime = item,
                    onEdit = {},
                    onDelete = {})
            }
        }
    }
}
