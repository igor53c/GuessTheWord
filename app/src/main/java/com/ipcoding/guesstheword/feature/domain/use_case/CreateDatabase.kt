package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.core.util.Constants.ALL_LETTERS
import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository

class CreateDatabase(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(number: Int): Boolean {
        letterRepository.deleteAll()
        for (row in 0 until number) {
            for (column in 0 until number) {
                letterRepository.insertLetter(
                    Letter(
                        row = row,
                        column = column
                    )
                )
            }
        }
        for (row in 0..2) {
            for (column in 0..8) {
                letterRepository.insertLetter(
                    Letter(
                        text = ALL_LETTERS[row * 9 + column],
                        row = row,
                        column = column,
                        isKeyboard = true,
                    )
                )
            }
        }
        return true
    }
}