package com.example.datastoreapp.storetype

import android.content.Context
import android.content.SharedPreferences

class SPStore(private val context: Context) {
    private val storage: SharedPreferences = context.getSharedPreferences(SP_NAME, 0)

    fun saveName(name: String) {
        storage.edit().putString(SP_USERNAME, name).apply()
    }

    fun getName(): String = storage.getString(SP_USERNAME, "username") ?: ""

    companion object {
        const val SP_NAME = "SPStore"
        const val SP_USERNAME = "SP_USERNAME"
    }
}
