package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository

class DeleteCurrentLetter(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(row: Int, column: Int, letters: List<Letter>, number: Int) : Int {

        var letter = letters.get(row * number + column)
        if(letter.text != "") {

            letter.text = ""
            letterRepository.insertLetter(letter)
            return column
        } else {
            val newPosition = (column + number - 1) % number
            letter = letters.get(row * number + newPosition)
            letter.text = ""
            letterRepository.insertLetter(letter)
            return newPosition
        }
    }
}