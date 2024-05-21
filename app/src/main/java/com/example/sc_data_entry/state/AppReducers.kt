package com.example.sc_data_entry.state

import org.reduxkotlin.Reducer
import org.reduxkotlin.typedReducer


val rootReducer: Reducer<AppState> = typedReducer<AppState,AppActions>{ state, action ->
    when(action){
        AppActions.Increment -> state.copy(
            count = state.count + 1
        )

        AppActions.Decrement -> state.copy(
            count = state.count - 1
        )
    }
}