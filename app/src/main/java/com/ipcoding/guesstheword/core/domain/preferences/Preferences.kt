package com.ipcoding.guesstheword.core.domain.preferences

interface Preferences {

    fun saveRandomWord(word: String)
    fun loadRandomWord(): String?

    fun saveIsDarkTheme(isDarkTheme: Boolean)
    fun loadIsDarkTheme(): Boolean

    companion object {
        const val RANDOM_WORD = "random_word"
        const val IS_DARK_THEME = "random_word"
    }
}