package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository

class DeleteCurrentLetter(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(row: Int, column: Int, letters: List<Letter>) : Int {

        var letter = letters.get(row * 5 + column)
        if(letter.text != "") {

            letter.text = ""
            letterRepository.insertLetter(letter)
            return column
        } else {
            val newPosition = (column + 4) % 5
            letter = letters.get(row * 5 + newPosition)
            letter.text = ""
            letterRepository.insertLetter(letter)
            return newPosition
        }
    }
}