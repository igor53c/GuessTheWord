package com.ipcoding.guesstheword.feature.data.data_source

import androidx.room.*
import com.ipcoding.guesstheword.feature.domain.model.Letter
import kotlinx.coroutines.flow.Flow

@Dao
interface LetterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLetter(letter: Letter)

    @Query("DELETE FROM letters_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM letters_table ORDER BY id ASC")
    fun getLetters(): Flow<List<Letter>>

    @Query("SELECT text FROM letters_table WHERE `row` = :row AND `column` = :column")
    suspend fun getLetter(row: Int, column: Int): String
}