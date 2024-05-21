package com.example.sc_data_entry.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.sc_data_entry.nav.AppNavHost
import com.example.sc_data_entry.nav.AppNavRoutes
import com.example.sc_data_entry.state.AppActions
import com.example.sc_data_entry.state.AppState
import org.reduxkotlin.compose.rememberDispatcher
import org.reduxkotlin.compose.selectState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomePage(
    navController: NavHostController = rememberNavController(),
){
    val currentPage = selectState<AppState,AppNavRoutes>{currentPage}
    val dispatch = rememberDispatcher()
    val scope = rememberCoroutineScope()
    PermanentNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(intrinsicSize = IntrinsicSize.Max)
            ) {

                Spacer(modifier = Modifier.height(50.dp))
                Column (
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
            ){
                   NavigationDrawerItem(
                       label = {
                            Row (
                                verticalAlignment = Alignment.CenterVertically
                       ){
                           Icon(
                               imageVector = Icons.Default.DateRange,
                               contentDescription = "Homepage")
                           Spacer(modifier = Modifier.width(8.dp))
                           Text(text = "Edit by Date")
                       }
                   },
                       selected = currentPage.value == AppNavRoutes.EDIT_BY_DATE_PAGE,//TODO: add logic to check if the user is currently in this page
                       onClick = {
                           navController.navigate(AppNavRoutes.EDIT_BY_DATE_PAGE.name)
                           dispatch(AppActions.NavigateToEditByDatePage)
                       //TODO: add navigation to EditByDatePage
                   })
                    NavigationDrawerItem(
                        label = {
                            Row (
                                verticalAlignment = Alignment.CenterVertically,
                            ){
                               Icon(
                                   imageVector = Icons.Default.Star,
                                   contentDescription = "Edit By Significance"
                               )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text(text = "Edit By Significance")
                            }
                    },
                        selected = currentPage.value == AppNavRoutes.EDIT_BY_SIGNIFICANCE_PAGE,
                        onClick = {
                            navController.navigate(AppNavRoutes.EDIT_BY_SIGNIFICANCE_PAGE.name)
                            dispatch(AppActions.NavigateToEditBySignificancePage)
                            //TODO: add navigation to EditBySignificancePage
                        })
                }
            }
        },
    ) {
        Scaffold(

            floatingActionButton = {
                FloatingActionButton(onClick = {
                    //TODO: // Add functionality to add significance
                }) {
                    Text(text = "+")
                }
            }
        ) {innerPadding ->
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                    AppNavHost(navController = navController)
                }
            }
        }

    }

