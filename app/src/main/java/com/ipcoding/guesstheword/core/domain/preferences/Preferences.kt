package com.ipcoding.guesstheword.core.domain.preferences

interface Preferences {

    fun saveRandomWord(word: String)
    fun loadRandomWord(): String?

    companion object {
        const val RANDOM_WORD = "random_word"
    }
}