package com.example.sc_data_entry.state

sealed class AppActions{
    data object Increment: AppActions()
    data object Decrement: AppActions()
}