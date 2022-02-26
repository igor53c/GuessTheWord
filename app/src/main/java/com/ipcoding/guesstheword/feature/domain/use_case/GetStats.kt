package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.repository.GameRepository

class GetStats(
    private val gameRepository: GameRepository
) {

    suspend operator fun invoke() : List<Float> {

        val statsList = mutableListOf<Float>()

        for (i in 4..7) {
            val games = gameRepository.getGames(i)
            var numberWins = 0

            for(game in games)
                if(game.isVictory) numberWins += 1

            if(games.isEmpty()) statsList.add(0f) else
                statsList.add(numberWins.toFloat() / games.size.toFloat())
        }

        return statsList
    }
}