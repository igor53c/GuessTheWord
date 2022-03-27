package com.ipcoding.guesstheword.feature.domain.repository

import com.ipcoding.guesstheword.feature.domain.model.Game

interface GameRepository {

    suspend fun insertGame(game: Game)

    suspend fun deleteGame(game: Game)

    suspend fun getGames(typeGameNumber: Int): List<Game>

    suspend fun numberOfGames(typeGameNumber: Int): Int

    suspend fun numberOfWins(typeGameNumber: Int): Int

    suspend fun winsFromAttempt(typeGameNumber: Int, numberAttempts: Int): Int
}