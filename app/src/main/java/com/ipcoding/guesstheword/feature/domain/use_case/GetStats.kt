package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.repository.GameRepository
import com.ipcoding.guesstheword.feature.domain.util.Stats

class GetStats(
    private val gameRepository: GameRepository
) {

    suspend operator fun invoke(): List<Stats> {

        val statsList = mutableListOf<Stats>()

        for (i in 4..7) {
            val games = gameRepository.getGames(i)
            var numberWins = 0
            var numberAttempts = 0

            for (game in games)
                if (game.isVictory) {
                    numberWins += 1
                    numberAttempts += game.numberAttempts
                }

            if (games.isEmpty()) statsList.add(Stats(0f, 0f)) else
                statsList.add(
                    Stats(
                        guessingSuccess = numberWins.toFloat() / games.size.toFloat(),
                        numberAttempts = numberAttempts.toFloat() / numberWins.toFloat()
                    )
                )
        }

        return statsList
    }
}