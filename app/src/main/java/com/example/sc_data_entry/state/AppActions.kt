package com.example.sc_data_entry.state

sealed class AppActions{
    data object NavigateToEditByDatePage: AppActions()
    data object  NavigateToEditBySignificancePage: AppActions()
}