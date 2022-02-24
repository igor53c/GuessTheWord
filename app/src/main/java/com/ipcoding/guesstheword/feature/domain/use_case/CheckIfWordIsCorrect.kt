package com.ipcoding.guesstheword.feature.domain.use_case

import android.util.Log
import androidx.compose.ui.graphics.toArgb
import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import com.ipcoding.guesstheword.ui.theme.Colors

class CheckIfWordIsCorrect(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(guessingWord: String, row: Int, letters: List<Letter>): Boolean {

        var wordIsCorrect = true
        val correctWord = mutableListOf<String>()
        val currentLetters = mutableListOf<String>()

        for(i in 0 until guessingWord.length) {
            correctWord.add(i, guessingWord[i].toString().lowercase())
            currentLetters.add(i, letters[row * 5 + i].text.lowercase())
        }

        for(i in 0..4) {

            val currentLetter = letters[row * 5 + i]

            if(correctWord[i] == currentLetters[i]) {

                currentLetter.color = Colors.Green.toArgb()
                correctWord[i] = ""
                currentLetters[i] = "_"
                letterRepository.insertLetter(currentLetter)
            } else  wordIsCorrect = false
        }

        for(i in 0..4) {

            val currentLetter = letters[row * 5 + i]

            if(correctWord.contains(currentLetters[i])) {
                currentLetter.color = Colors.Yellow.toArgb()
                correctWord[correctWord.indexOf(currentLetters[i])] = ""
                letterRepository.insertLetter(currentLetter)
            }
        }

        return wordIsCorrect
    }
}