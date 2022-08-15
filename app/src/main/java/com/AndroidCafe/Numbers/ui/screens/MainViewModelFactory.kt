package com.AndroidCafe.Numbers.ui.screens

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val dataStore: DataStore<Preferences>)
    : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dataStore) as T
        }

        throw IllegalArgumentException("Unknown ViewModel class")
    }
}