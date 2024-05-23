package com.example.sc_data_entry.state

import com.example.sc_data_entry.nav.AppNavRoutes
import com.example.sc_data_entry.models.DateResponse
import com.example.sc_data_entry.models.Significance
import com.example.sc_data_entry.models.SignificanceType
import java.time.LocalDate

data class AppState(
    val showAddSignificanceDialog: Boolean = false,
    val showAddPrayerTimeDialog: Boolean = false,
    val addSignificanceDialogSignificanceType: SignificanceType =SignificanceType.POURNAMI,
    val isLoading : Boolean = false,
    val currentPage : AppNavRoutes = AppNavRoutes.EDIT_BY_DATE_PAGE,
    val selectedDate : LocalDate,
    val dateResponse: DateResponse,
    val dateResponseUpdated: DateResponse,
)