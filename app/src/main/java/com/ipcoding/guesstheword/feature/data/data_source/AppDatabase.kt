package com.ipcoding.guesstheword.feature.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ipcoding.guesstheword.feature.domain.model.Game
import com.ipcoding.guesstheword.feature.domain.model.Letter

@Database(
    entities = [Letter::class, Game::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract val letterDao: LetterDao

    abstract val gameDao: GameDao

    companion object {
        const val DATABASE_NAME = "guesstheword_db"
    }
}