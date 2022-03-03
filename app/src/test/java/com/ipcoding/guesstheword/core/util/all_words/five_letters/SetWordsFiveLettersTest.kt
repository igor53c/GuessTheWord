package com.ipcoding.guesstheword.core.util.all_words.five_letters

import com.ipcoding.guesstheword.core.util.all_words.five_letters.SetWordsFiveLetters.SET_WORDS_FIVE_LETTERS
import org.junit.Assert.assertTrue
import org.junit.Test

class SetWordsFiveLettersTest {

    @Test
    fun `whether all the words are five letters long`() {
        val list = SET_WORDS_FIVE_LETTERS.filter {
            it.length != 5
        }

        assertTrue(list.isEmpty())
    }
}