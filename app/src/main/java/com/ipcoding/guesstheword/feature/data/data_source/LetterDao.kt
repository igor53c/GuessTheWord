package com.ipcoding.guesstheword.feature.data.data_source

import androidx.room.*
import com.ipcoding.guesstheword.feature.domain.model.Letter
import kotlinx.coroutines.flow.Flow

@Dao
interface LetterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLetter(letter: Letter)

    @Delete
    suspend fun deleteLetter(letter: Letter)

    @Query("DELETE FROM letters_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM letters_table WHERE NOT isKeyboard ORDER BY id ASC")
    fun getLettersFlow(): Flow<List<Letter>>

    @Query("SELECT * FROM letters_table WHERE isKeyboard ORDER BY id ASC")
    fun getKeyboardLettersFlow(): Flow<List<Letter>>

    @Query("SELECT * FROM letters_table WHERE NOT isKeyboard ORDER BY id ASC")
    suspend fun getLetters(): List<Letter>

    @Query("SELECT text FROM letters_table " +
            "WHERE NOT isKeyboard AND `row` = :row AND `column` = :column")
    suspend fun getLetter(row: Int, column: Int): String

    @Query("SELECT * FROM letters_table WHERE isKeyboard AND `text` = :text LIMIT 1")
    suspend fun getKeyboardLetter(text: String): Letter
}