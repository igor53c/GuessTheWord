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
}