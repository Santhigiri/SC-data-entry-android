package com.example.sc_data_entry.state

import java.time.LocalDate

sealed interface AppActions{
    data object NavigateToEditByDatePage: AppActions
    data object  NavigateToEditBySignificancePage: AppActions

    data class ChangeDate(val selectedDate: LocalDate) : AppActions
}