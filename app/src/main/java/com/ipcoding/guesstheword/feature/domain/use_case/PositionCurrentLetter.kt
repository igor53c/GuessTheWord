package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.model.Letter

class PositionCurrentLetter {

    operator fun invoke(row: Int, position: Int, letters: List<Letter>) : Int {
        for(i in position..position + 4) {

            val newPosition = (i + 1) % 5

            if(letters.get(row * 5 + newPosition).text == "")
                return newPosition
        }
        return position
    }
}