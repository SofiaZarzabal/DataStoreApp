package com.example.datastoreapp.storetype

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PreferencesDataStore(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PDS_NAME)
    private val dataStore = context.dataStore
    private val pdsAge = intPreferencesKey(PDS_AGE_KEY)

    fun getAge(): Flow<Int> =
        context.dataStore.data.map { preferences -> preferences[pdsAge] ?: MINUS_ONE }

    suspend fun setAge(age: Int) {
        dataStore.edit { preferences -> preferences[pdsAge] = age }
    }

    companion object {
        private const val PDS_NAME = "PDSStore"
        private const val PDS_AGE_KEY = "PDS_AGE_KEY"
        private const val MINUS_ONE = -1
    }
}
