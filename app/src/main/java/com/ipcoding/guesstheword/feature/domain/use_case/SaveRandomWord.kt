package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.core.domain.preferences.Preferences
import com.ipcoding.guesstheword.core.util.all_words.five_letters.SetWordsFiveLetters.SET_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.SetWordsFourLetters.SET_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.seven_words.SetWordsSevenLetters.SET_WORDS_SEVEN_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.SetWordsSixLetters.SET_WORDS_SIX_LETTERS

class SaveRandomWord(
    private val preferences: Preferences
) {

    operator fun invoke(number: Int) {
        when (number) {
            4 -> preferences.saveRandomWord(SET_WORDS_FOUR_LETTERS.random())
            5 -> preferences.saveRandomWord(SET_WORDS_FIVE_LETTERS.random())
            6 -> preferences.saveRandomWord(SET_WORDS_SIX_LETTERS.random())
            7 -> preferences.saveRandomWord(SET_WORDS_SEVEN_LETTERS.random())
        }
    }
}