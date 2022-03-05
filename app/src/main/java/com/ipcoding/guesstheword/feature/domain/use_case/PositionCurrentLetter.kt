package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository

class PositionCurrentLetter(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(row: Int, position: Int, number: Int): Int {

        val letters = letterRepository.getLetters()

        for (i in position until position + number) {

            val newPosition = (i + 1) % number

            if (letters[row * number + newPosition].text == "")
                return newPosition
        }
        return position
    }
}