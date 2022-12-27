package com.example.datastoreapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.datastoreapp.storetype.SPStore

class InfoManagerViewModel(private val spStorage: SPStore) : ViewModel() {

    fun saveInfoPressed(userName: String) {
        spStorage.saveName(userName)
    }

    fun loadInfoPressed(): String = spStorage.getName()
}
