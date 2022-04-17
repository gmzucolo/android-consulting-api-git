package com.example.gmzucolo.appconsultingapigit.commons

import android.content.Context
import android.content.SharedPreferences

class Prefs(val context: Context) {

    companion object {
        private const val PREFS_NAME = "AppConsultingApiGit"
        const val PREF_ID_REPO = "PREF_ID_REPO"
    }

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun save(KEY_NAME: String, text: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_NAME, text)
        editor.apply()
    }

    fun getValueString(KEY_NAME: String): String? {
        return sharedPref.getString(KEY_NAME, null)
    }
}