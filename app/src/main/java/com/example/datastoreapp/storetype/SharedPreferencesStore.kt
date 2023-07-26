package com.example.datastoreapp.storetype

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesStore(private val context: Context) {
    private val storage: SharedPreferences = context.getSharedPreferences(SP_NAME, 0)

    fun saveName(name: String) {
        storage.edit().putString(SP_USERNAME, name).apply()
    }

    fun getName(): String = storage.getString(SP_USERNAME, DEFAULT_INFO) ?: EMPTY_STRING

    companion object {
        const val SP_NAME = "SPStore"
        const val SP_USERNAME = "SP_USERNAME"
        const val DEFAULT_INFO = "No info loaded."
        const val EMPTY_STRING = ""
    }
}
