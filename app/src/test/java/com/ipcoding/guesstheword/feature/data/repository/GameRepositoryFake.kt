package com.ipcoding.guesstheword.feature.data.repository

import com.ipcoding.guesstheword.feature.domain.model.Game
import com.ipcoding.guesstheword.feature.domain.repository.GameRepository

class GameRepositoryFake : GameRepository {

    private var games = mutableListOf<Game>()

    override suspend fun insertGame(game: Game) {
        games.add(game)
    }

    override suspend fun deleteGame(game: Game) {
        games.remove(game)
    }

    override suspend fun getGames(typeGameNumber: Int): List<Game> {
        return games.filter { it.typeGameNumber == typeGameNumber }.sortedBy { it.id }
    }

    override suspend fun numberOfGames(typeGameNumber: Int): Int {
        return games.filter { it.typeGameNumber == typeGameNumber }.size
    }

    override suspend fun numberOfWins(typeGameNumber: Int): Int {
        return games.filter { it.typeGameNumber == typeGameNumber && it.isVictory }.size
    }

    override suspend fun winsFromAttempt(typeGameNumber: Int, numberAttempts: Int): Int {
        return games.filter {
            it.typeGameNumber == typeGameNumber &&
                    it.numberAttempts == numberAttempts && it.isVictory
        }.size
    }
}