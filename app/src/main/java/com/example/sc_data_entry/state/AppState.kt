package com.example.sc_data_entry.state

import com.example.sc_data_entry.nav.AppNavRoutes
import com.example.sc_data_entry.models.DateResponse
import java.time.LocalDate

data class AppState(
    val isLoading : Boolean = false,
    val currentPage : AppNavRoutes = AppNavRoutes.EDIT_BY_DATE_PAGE,
    val selectedDate : LocalDate,
    val dateResponse: DateResponse,
    val dateResponseUpdated: DateResponse,
)