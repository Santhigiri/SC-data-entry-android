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
import org.reduxkotlin.compose.StoreProvider
import org.reduxkotlin.createStore
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
                        selectedDate = LocalDate.now()
            ))) {
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
//
//@Composable
//fun HomeScreen( modifier: Modifier = Modifier) {
//    val significance =  remember {
//        mutableStateOf("No data fetched")
//    }
//    val count by selectState<AppState,Int> {
//        count
//    }
//    val dispatch = rememberDispatcher()
//    Column (
//        modifier = Modifier.fillMaxWidth(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceEvenly
//        ) {
//            Button(onClick = {
//                dispatch(AppActions.Decrement)
//            }) {
//                Text(text = "-")
//            }
//            Text("$count")
//            Button(onClick = {
//                dispatch(AppActions.Increment)
//            }) {
//                Text(text = "+")
//            }
//        }
//        Text(significance.value)
//        Button(onClick = {
//                CoroutineScope(Dispatchers.Default).launch {
//
//                    val data : DateResponse = AppRepository().getDateResponse()
//                    withContext(Dispatchers.Main){
//
//                        significance.value = data.significances.toString()
//                        println(data.significances.toString())
//                    }
//                }
//        }) {
//            Text(text = "Fetch data")
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    AppTheme {
//        PrimaryButton(label = "Test") {
//
//        }
//    }
//}