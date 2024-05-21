package com.example.sc_data_entry.state

import com.example.sc_data_entry.nav.AppNavRoutes
import org.reduxkotlin.Reducer
import org.reduxkotlin.typedReducer


val rootReducer: Reducer<AppState> = typedReducer<AppState,AppActions>{ state, action ->
    when(action){
        AppActions.NavigateToEditByDatePage -> state.copy(currentPage = AppNavRoutes.EDIT_BY_DATE_PAGE)
        AppActions.NavigateToEditBySignificancePage -> state.copy(currentPage = AppNavRoutes.EDIT_BY_SIGNIFICANCE_PAGE)
    }
}