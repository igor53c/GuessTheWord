package com.ipcoding.guesstheword.feature.domain.use_case

import androidx.compose.ui.graphics.toArgb
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import com.ipcoding.guesstheword.ui.theme.Colors

class CheckAllLettersEntered(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(row: Int, number: Int): Boolean {

        val letters = letterRepository.getLetters()
        var areEntered = true

        for (column in 0 until number) {
            val letter = letters[row * number + column]
            if (letter.text == "") {
                areEntered = false
                letter.color = Colors.Error.toArgb()
                letterRepository.insertLetter(letter)
            }
        }
        return areEntered
    }
}