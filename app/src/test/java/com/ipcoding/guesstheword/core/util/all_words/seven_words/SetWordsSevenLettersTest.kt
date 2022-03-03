package com.ipcoding.guesstheword.core.util.all_words.seven_words

import com.ipcoding.guesstheword.core.util.all_words.seven_words.SetWordsSevenLetters.SET_WORDS_SEVEN_LETTERS
import org.junit.Assert.assertTrue
import org.junit.Test

class SetWordsSevenLettersTest {

    @Test
    fun `whether all the words are seven letters long`() {
        val list = SET_WORDS_SEVEN_LETTERS.filter {
            it.length != 7
        }

        assertTrue(list.isEmpty())
    }
}