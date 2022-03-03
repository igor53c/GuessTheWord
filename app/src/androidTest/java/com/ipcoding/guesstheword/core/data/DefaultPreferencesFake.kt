package com.ipcoding.guesstheword.core.data

import com.ipcoding.guesstheword.core.domain.preferences.Preferences

class DefaultPreferencesFake : Preferences {

    private var randomWord: String? = null
    private var isDarkThemeValue: Boolean = false

    override fun saveRandomWord(word: String) {
        randomWord = word
    }

    override fun loadRandomWord(): String? {
        return randomWord
    }

    override fun saveIsDarkTheme(isDarkTheme: Boolean) {
        isDarkThemeValue = isDarkTheme
    }

    override fun loadIsDarkTheme(): Boolean {
        return isDarkThemeValue
    }
}