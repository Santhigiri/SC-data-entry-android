package com.example.sc_data_entry

import AppTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.sc_data_entry.models.dateJsonResponse
import com.example.sc_data_entry.nav.AppNavRoutes
import com.example.sc_data_entry.screens.HomePage
import com.example.sc_data_entry.state.AppState
import com.example.sc_data_entry.state.rootReducer
import kotlinx.serialization.json.Json
import org.reduxkotlin.applyMiddleware
import org.reduxkotlin.compose.StoreProvider
import org.reduxkotlin.createStore
import org.reduxkotlin.thunk.createThunkMiddleware
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StoreProvider(
                store = createStore(
                    rootReducer,
                    AppState(
                dateResponse = Json.decodeFromString(dateJsonResponse),
                        selectedDate = LocalDate.now(),
                        dateResponseUpdated = Json.decodeFromString(dateJsonResponse)
            ), applyMiddleware(createThunkMiddleware())
                    )) {
                AppTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        HomePage()
                    }
                }
            }

        }
    }
}