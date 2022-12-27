package com.example.datastoreapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class StoreType {
    SHARED_PREFERENCES,
    PROTO_DATASTORE,
    PREFERENCES_DATASTORE
}

class MainViewModel : ViewModel() {

    private val mutableLiveData: MutableLiveData<MainData> = MutableLiveData()
    fun getValue(): LiveData<MainData> {
        return mutableLiveData
    }

    fun onButtonPressed(storeType: StoreType) {
        when (storeType) {
            StoreType.SHARED_PREFERENCES -> mutableLiveData.value = MainData(MainStates.GO_TO_SHARED_PREFERENCES_VIEW)
            StoreType.PROTO_DATASTORE -> mutableLiveData.value = MainData(MainStates.GO_TO_PROTO_DATASTORE_VIEW)
            StoreType.PREFERENCES_DATASTORE -> mutableLiveData.value = MainData(MainStates.GO_TO_PREFERENCES_DATASTORE_VIEW)
        }
    }

    data class MainData(
        val state: MainStates
    )

    enum class MainStates {
        GO_TO_SHARED_PREFERENCES_VIEW,
        GO_TO_PROTO_DATASTORE_VIEW,
        GO_TO_PREFERENCES_DATASTORE_VIEW
    }
}
