package com.example.sc_data_entry.state

import com.example.sc_data_entry.models.Significance
import com.example.sc_data_entry.models.SignificanceType
import com.example.sc_data_entry.models.dateJsonResponse
import com.example.sc_data_entry.nav.AppNavRoutes
import com.example.sc_data_entry.utils.SignificanceFactory
import org.reduxkotlin.Reducer
import org.reduxkotlin.typedReducer


val rootReducer: Reducer<AppState> = typedReducer<AppState,AppActions>{ state, action ->
    when(action){
        is AppActions.NavigateToEditByDatePage -> state.copy(currentPage = AppNavRoutes.EDIT_BY_DATE_PAGE)

        is AppActions.NavigateToEditBySignificancePage -> state.copy(currentPage = AppNavRoutes.EDIT_BY_SIGNIFICANCE_PAGE)

        is AppActions.ChangeDate -> state.copy(selectedDate = action.selectedDate)

        is AppActions.AddSignificance -> {
            val newSignificance = SignificanceFactory().getSignificance(action.significanceType)
            val updatedSignificances: List<Significance> =  listOf(newSignificance) + state.dateResponse.significances
            state.copy(
                dateResponse = state.dateResponse.copy(
                    significances = updatedSignificances
                )
            )
        }

        is AppActions.AddSpecialPrayer -> state.copy(
            dateResponse = state.dateResponse.copy(
                prayers = listOf(action.prayerTime) + state.dateResponse.prayers
        ))

        is AppActions.EditVariablePrayer -> TODO()

        is AppActions.RemoveSignificance -> TODO()

        is AppActions.RemoveSpecialPrayer -> TODO()

        is AppActions.DataFetchingStarted -> state.copy(isLoading = true)

        is AppActions.DataFetchingStopped -> state.copy(isLoading = false)

        is AppActions.ShowSignificanceDialog -> state.copy(showAddSignificanceDialog = true)

        is AppActions.HideSignificanceDialog -> state.copy(showAddSignificanceDialog = false)
    }
}