package com.ipcoding.guesstheword.core.util.all_words.four_letters

import com.ipcoding.guesstheword.core.util.all_words.four_letters.SetWordsFourLetters.SET_WORDS_FOUR_LETTERS
import org.junit.Assert.assertTrue
import org.junit.Test

class SetWordsFourLettersTest {

    @Test
    fun `whether all the words are four letters long`() {
        val list = SET_WORDS_FOUR_LETTERS.filter {
            it.length != 4
        }

        assertTrue(list.isEmpty())
    }
}