package com.example.sc_data_entry.state

import com.example.sc_data_entry.nav.AppNavRoutes
import com.example.sc_data_entry.models.DateResponse

data class AppState(
    val currentPage : AppNavRoutes = AppNavRoutes.EDIT_BY_DATE_PAGE,
    val dateResponse: DateResponse,
)