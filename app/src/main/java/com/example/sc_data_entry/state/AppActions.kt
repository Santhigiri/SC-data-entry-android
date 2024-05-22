package com.example.sc_data_entry.state

import com.example.sc_data_entry.models.Significance
import java.time.LocalDate

sealed interface AppActions{
    data object DataFetchingStarted: AppActions
    data object DataFetchingStopped: AppActions
    data object NavigateToEditByDatePage: AppActions
    data object  NavigateToEditBySignificancePage: AppActions
    data class ChangeDate(val selectedDate: LocalDate) : AppActions
    data class AddSignificance(val significance: Significance) : AppActions
    data class RemoveSignificance(val significance: Significance) : AppActions
    data class EditVariablePrayer(val prayerTime: String) : AppActions
    data class AddSpecialPrayer(val prayerTime: String) : AppActions
    data class RemoveSpecialPrayer(val prayerTime: String) : AppActions
}