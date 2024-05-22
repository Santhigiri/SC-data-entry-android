package com.example.sc_data_entry.state

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.reduxkotlin.thunk.Thunk


fun addPrayerTimeThunk(coroutineScope: CoroutineScope, prayerTime: String) :Thunk<AppState> = { dispatch, _, _ ->
    dispatch(AppActions.DataFetchingStarted)
    coroutineScope.launch(Dispatchers.IO) {
        delay(3000)//mimicking api call
        dispatch(AppActions.DataFetchingStopped)
        dispatch(AppActions.AddSpecialPrayer(prayerTime = prayerTime))
    }
}