package com.ipcoding.guesstheword.core.util.all_words.six_letters

import com.ipcoding.guesstheword.core.util.all_words.six_letters.SetWordsSixLetters.SET_WORDS_SIX_LETTERS
import org.junit.Assert.assertTrue
import org.junit.Test

class SetWordsSixLettersTest {

    @Test
    fun `whether all the words are six letters long`() {
        val list = SET_WORDS_SIX_LETTERS.filter {
            it.length != 6
        }

        assertTrue(list.size == 0)
    }
}