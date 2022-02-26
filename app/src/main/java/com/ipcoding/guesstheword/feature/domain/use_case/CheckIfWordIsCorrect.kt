package com.ipcoding.guesstheword.feature.domain.use_case

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.ipcoding.guesstheword.core.util.Constants.DURATION_LETTER_ANIMATION
import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import com.ipcoding.guesstheword.ui.theme.Colors
import kotlinx.coroutines.delay

class CheckIfWordIsCorrect(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(guessingWord: String, row: Int, number: Int): Boolean {

        var wordIsCorrect = true
        val correctWord = mutableListOf<String>()
        val currentVariableLetters = mutableListOf<String>()
        val currentLetters = mutableListOf<Letter>()
        val letters = letterRepository.getLetters()

        for(i in guessingWord.indices) {
            val currentLetter = letters[row * number + i]
            currentLetters.add(i, currentLetter)
            correctWord.add(i, guessingWord[i].toString().lowercase())
            currentVariableLetters.add(i, currentLetter.text.lowercase())
            currentLetter.color = Color.Transparent.toArgb()
            letterRepository.insertLetter(currentLetter)
            currentLetter.color = Colors.Blue.toArgb()
            delay((DURATION_LETTER_ANIMATION / 5).toLong())
        }

        for(i in 0 until number) {

            val currentLetter = letters[row * number + i]

            if(correctWord[i] == currentVariableLetters[i]) {

                currentLetter.color = Colors.Green.toArgb()
                correctWord[i] = ""
                currentVariableLetters[i] = "_"
                currentLetters[i] = currentLetter

                val keyboardLetter = letterRepository.getKeyboardLetter(currentLetter.text)
                keyboardLetter.color = Colors.Green.toArgb()
                letterRepository.insertLetter(keyboardLetter)

            } else  wordIsCorrect = false
        }

        for(i in 0 until number) {

            val currentLetter = letters[row * number + i]

            if(correctWord.contains(currentVariableLetters[i])) {
                currentLetter.color = Colors.Yellow.toArgb()
                correctWord[correctWord.indexOf(currentVariableLetters[i])] = ""
                currentVariableLetters[i] = "_"
                currentLetters[i] = currentLetter

                val keyboardLetter = letterRepository.getKeyboardLetter(currentLetter.text)
                if(keyboardLetter.color != Colors.Green.toArgb()) {
                    keyboardLetter.color = Colors.Yellow.toArgb()
                    letterRepository.insertLetter(keyboardLetter)
                }
            }
        }

        for(i in 0 until number) {
            letterRepository.insertLetter(currentLetters[i])
            delay((DURATION_LETTER_ANIMATION / 5).toLong())
        }

        for(i in 0 until number) {

            val currentLetter = letters[row * number + i]

            if(currentVariableLetters[i] != "_") {
                val keyboardLetter = letterRepository.getKeyboardLetter(currentLetter.text)
                if(
                    keyboardLetter.color != Colors.Green.toArgb() &&
                    keyboardLetter.color != Colors.Yellow.toArgb()
                ) {
                    keyboardLetter.color = Colors.Gray.toArgb()
                    letterRepository.insertLetter(keyboardLetter)
                }
            }
        }

        if(wordIsCorrect) delay((DURATION_LETTER_ANIMATION / 3).toLong())

        return wordIsCorrect
    }
}