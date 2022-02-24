package com.ipcoding.guesstheword.feature.domain.use_case

import androidx.compose.ui.graphics.toArgb
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import com.ipcoding.guesstheword.ui.theme.Colors

class CheckIfWordIsCorrect(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(guessingWord: String, row: Int): Boolean {

        var wordIsCorrect = true
        val correctWord = mutableListOf<String>()
        val currentLetters = mutableListOf<String>()
        val letters = letterRepository.getLetters()

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
                val keyboardLetter = letterRepository.getKeyboardLetter(currentLetter.text)
                keyboardLetter.color = Colors.Green.toArgb()
                letterRepository.insertLetter(keyboardLetter)

            } else  wordIsCorrect = false
        }

        for(i in 0..4) {

            val currentLetter = letters[row * 5 + i]

            if(correctWord.contains(currentLetters[i])) {
                currentLetter.color = Colors.Yellow.toArgb()
                correctWord[correctWord.indexOf(currentLetters[i])] = ""
                currentLetters[i] = "_"
                letterRepository.insertLetter(currentLetter)
                val keyboardLetter = letterRepository.getKeyboardLetter(currentLetter.text)
                if(keyboardLetter.color != Colors.Green.toArgb()) {
                    keyboardLetter.color = Colors.Yellow.toArgb()
                    letterRepository.insertLetter(keyboardLetter)
                }
            }
        }

        for(i in 0..4) {

            val currentLetter = letters[row * 5 + i]

            if(currentLetters[i] != "_") {
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

        return wordIsCorrect
    }
}