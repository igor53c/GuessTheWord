package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.model.Game
import com.ipcoding.guesstheword.feature.domain.repository.GameRepository

class InsertGame(
    private val gameRepository: GameRepository
) {

    suspend operator fun invoke(
        typeGameNumber: Int,
        guessingWord: String,
        isVictory: Boolean,
        numberAttempts: Int
    ) {
        gameRepository.insertGame(
            Game(
                typeGameNumber = typeGameNumber,
                guessingWord = guessingWord,
                isVictory = isVictory,
                numberAttempts = numberAttempts
            )
        )
    }
}