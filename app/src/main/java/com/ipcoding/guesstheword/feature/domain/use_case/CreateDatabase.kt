package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository

class CreateDatabase(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke() {
        letterRepository.deleteAll()
        for (row in 0..4) {
            for (column in 0..4) {
                letterRepository.insertLetter(
                    Letter(
                        row = row,
                        column = column
                    )
                )
            }
        }
    }
}