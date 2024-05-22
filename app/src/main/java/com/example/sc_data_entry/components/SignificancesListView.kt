package com.example.sc_data_entry.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sc_data_entry.models.Significance
import components.cards.SignificanceListItem

@Composable
fun SignificancesListView(significances: List<Significance>){
    LazyColumn(
        modifier = Modifier.fillMaxWidth(0.5f),
    ) {
        items(significances.size) { index ->
            SignificanceListItem(labelText = significances[index].name) {}

        }
    }
}