package com.ipcoding.guesstheword.feature.domain.repository

import com.ipcoding.guesstheword.feature.domain.model.Letter
import kotlinx.coroutines.flow.Flow

interface LetterRepository {

    suspend fun insertLetter(letter: Letter)

    suspend fun deleteAll()

    fun getLetters(): Flow<List<Letter>>

    suspend fun getLetter(row: Int, column: Int): String
}