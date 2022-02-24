package com.ipcoding.guesstheword.feature.domain.repository

import com.ipcoding.guesstheword.feature.domain.model.Letter
import kotlinx.coroutines.flow.Flow

interface LetterRepository {

    suspend fun insertLetter(letter: Letter)

    suspend fun deleteLetter(letter: Letter)

    suspend fun deleteAll()

    fun getLettersFlow(): Flow<List<Letter>>

    fun getKeyboardLettersFlow(): Flow<List<Letter>>

    suspend fun getLetters(): List<Letter>

    suspend fun getLetter(row: Int, column: Int): String

    suspend fun getKeyboardLetter(text: String): Letter
}