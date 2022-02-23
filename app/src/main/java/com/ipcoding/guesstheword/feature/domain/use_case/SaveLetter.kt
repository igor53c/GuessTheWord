package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository

class SaveLetter(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(char: String, row: Int, column: Int) {
        letterRepository.insertLetter(
            Letter(
                text =  char,
                row = row,
                column = column,
                id = row * 5 + column + 1
            )
        )
    }
}