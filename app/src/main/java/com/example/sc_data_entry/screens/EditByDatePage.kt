package com.example.sc_data_entry.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import components.cards.SpecialPrayerCard
import components.cards.VariablePrayerCard
import org.reduxkotlin.compose.selectState
import ui.theme.appTypography

@Composable
fun EditByDatePage(

){
    val dateResponse by selectState < AppState, DateResponse>{dateResponse}
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
        ) {
            Text(
                text = "Santhigiri Calendar",
                style = appTypography.headlineSmall
            )
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
        itemsIndexed(prayers){index, item ->
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

