package com.ipcoding.guesstheword.core.data

import android.content.SharedPreferences
import com.ipcoding.guesstheword.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
) : Preferences {

    override fun saveRandomWord(word: String) {
        sharedPreferences
            .edit()
            .putString(Preferences.RANDOM_WORD, word)
            .apply()
    }

    override fun loadRandomWord(): String? {
        return sharedPreferences.getString(Preferences.RANDOM_WORD, null)
    }

    override fun saveIsDarkTheme(isDarkTheme: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(Preferences.IS_DARK_THEME, isDarkTheme)
            .apply()
    }

    override fun loadIsDarkTheme(): Boolean {
        return sharedPreferences.getBoolean(Preferences.IS_DARK_THEME, false)
    }
}