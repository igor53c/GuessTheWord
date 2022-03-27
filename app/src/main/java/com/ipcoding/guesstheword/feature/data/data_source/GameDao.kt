package com.ipcoding.guesstheword.feature.data.data_source

import androidx.room.*
import com.ipcoding.guesstheword.feature.domain.model.Game

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)

    @Query("SELECT * FROM games_table WHERE typeGameNumber = :typeGameNumber ORDER BY id ASC")
    suspend fun getGames(typeGameNumber: Int): List<Game>

    @Query("SELECT COUNT(*) FROM games_table WHERE typeGameNumber = :typeGameNumber")
    suspend fun numberOfGames(typeGameNumber: Int): Int

    @Query(
        "SELECT COUNT(*) FROM games_table WHERE "
                + "typeGameNumber = :typeGameNumber AND isVictory"
    )
    suspend fun numberOfWins(typeGameNumber: Int): Int

    @Query(
        "SELECT COUNT(*) FROM games_table WHERE typeGameNumber = :typeGameNumber "
                + "AND numberAttempts = :numberAttempts AND isVictory"
    )
    suspend fun winsFromAttempt(typeGameNumber: Int, numberAttempts: Int): Int
}