package com.ipcoding.guesstheword.feature.domain.use_case

import androidx.compose.ui.graphics.toArgb
import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import com.ipcoding.guesstheword.ui.theme.Colors

class CheckAllLettersEntered(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(row: Int, letters: List<Letter>): Boolean {

        var areEntered = true

        for (column in 0..4) {
            val letter = letters[row * 5 + column]
            if(letter.text == "") {
                areEntered = false
                letter.color = Colors.Error.toArgb()
                letterRepository.insertLetter(letter)
            }
        }
        return areEntered
    }
}