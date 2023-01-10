package com.example.datastoreapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.datastoreapp.storetype.SharedPreferencesStore

class SharedPreferencesViewModel(private val sharedPreferencesStorage: SharedPreferencesStore) : ViewModel() {

    fun saveInfoPressed(userName: String) {
        sharedPreferencesStorage.saveName(userName)
    }

    fun loadInfoPressed(): String = sharedPreferencesStorage.getName()
}
