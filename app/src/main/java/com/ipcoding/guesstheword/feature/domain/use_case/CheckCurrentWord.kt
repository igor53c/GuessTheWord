package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository

class CheckCurrentWord(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(row: Int) : String {
        var word = ""
        for(column in 0..4) {
            word += letterRepository.getLetter(row, column)
        }
        return word
    }
}