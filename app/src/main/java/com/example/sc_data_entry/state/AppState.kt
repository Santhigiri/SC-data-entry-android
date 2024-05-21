package com.example.sc_data_entry.state

import com.example.sc_data_entry.nav.AppNavRoutes

data class AppState(
    val count: Int,
    val currentPage : AppNavRoutes = AppNavRoutes.EDIT_BY_DATE_PAGE,
)