package com.example.sc_data_entry.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sc_data_entry.screens.EditByDatePage
import com.example.sc_data_entry.screens.EditBySignificancePage

@Composable
fun AppNavHost(navController: NavHostController){

    NavHost(navController = navController, startDestination = AppNavRoutes.EDIT_BY_DATE_PAGE.name ){
        composable(AppNavRoutes.EDIT_BY_DATE_PAGE.name){
            EditByDatePage()
        }

        composable(AppNavRoutes.EDIT_BY_SIGNIFICANCE_PAGE.name){
            EditBySignificancePage()
        }

    }
}