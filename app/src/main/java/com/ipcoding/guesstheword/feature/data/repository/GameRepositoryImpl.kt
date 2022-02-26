package com.ipcoding.guesstheword.feature.data.repository

import com.ipcoding.guesstheword.feature.data.data_source.GameDao
import com.ipcoding.guesstheword.feature.domain.model.Game
import com.ipcoding.guesstheword.feature.domain.repository.GameRepository

class GameRepositoryImpl(
    private val dao: GameDao
) : GameRepository {

    override suspend fun insertGame(game: Game) {
        dao.insertGame(game)
    }

    override suspend fun deleteGame(game: Game) {
        dao.deleteGame(game)
    }

    override suspend fun getGames(typeGameNumber: Int): List<Game> {
        return dao.getGames(typeGameNumber)
    }
}