package com.assign.openinapp.utils

import android.app.Application
import android.content.Context
import android.content.SharedPreferences

class AppDelegate : Application() {

    companion object {
        private const val PREFS_NAME = "MyPrefs"
        private const val KEY_BEARER_TOKEN = "bearerToken"

        private lateinit var instance: AppDelegate

        fun getInstance(): AppDelegate {
            return instance
        }
    }

    private lateinit var sharedPreferences: SharedPreferences

    var bearerToken: String? = null
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        bearerToken = sharedPreferences.getString(KEY_BEARER_TOKEN, null)
    }

    fun saveBearerToken(token: String) {
        bearerToken = token

        val editor = sharedPreferences.edit()
        editor.putString(KEY_BEARER_TOKEN, token)
        editor.apply()
    }
}