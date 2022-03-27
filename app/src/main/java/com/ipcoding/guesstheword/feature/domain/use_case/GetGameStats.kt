package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.repository.GameRepository
import com.ipcoding.guesstheword.feature.domain.util.GameStats

class GetGameStats(
    private val gameRepository: GameRepository
) {

    suspend operator fun invoke(typeGameNumber: Int): GameStats {

        val winsFromAttempts = mutableListOf<Int>()

        for (numberAttempts in 1..typeGameNumber) {
            winsFromAttempts.add(gameRepository.winsFromAttempt(typeGameNumber, numberAttempts))
        }

        return GameStats(
            totalGamesPlayed = gameRepository.numberOfGames(typeGameNumber),
            numberOfWins = gameRepository.numberOfWins(typeGameNumber),
            winsFromAttempts = winsFromAttempts
        )
    }
}