package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.model.Letter

class PositionCurrentLetter {

    operator fun invoke(row: Int, position: Int, letters: List<Letter>, number: Int) : Int {
        for(i in position..position + number - 1) {

            val newPosition = (i + 1) % number

            if(letters.get(row * number + newPosition).text == "")
                return newPosition
        }
        return position
    }
}