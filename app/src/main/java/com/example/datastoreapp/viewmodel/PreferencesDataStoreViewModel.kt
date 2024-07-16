package com.example.datastoreapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.datastoreapp.storetype.PreferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PreferencesDataStoreViewModel(private val preferencesDataStoreStorage: PreferencesDataStore) :
    ViewModel() {

    private val mutableLiveData = MutableLiveData<Int>()
    val liveData: LiveData<Int>
        get() = mutableLiveData

    fun saveInfoPressed(ageInput: String) {
        val age = if (ageInput.isEmpty()) MINUS_ONE else ageInput.toInt()
        viewModelScope.launch(Dispatchers.IO) {
            preferencesDataStoreStorage.setAge(age)
        }
    }

    fun loadInfoPressed() {
        viewModelScope.launch(Dispatchers.IO) {
            preferencesDataStoreStorage.getAge().collect {
                mutableLiveData.postValue(it)
            }
        }
    }

    companion object{
        const val MINUS_ONE = -1
    }
}
