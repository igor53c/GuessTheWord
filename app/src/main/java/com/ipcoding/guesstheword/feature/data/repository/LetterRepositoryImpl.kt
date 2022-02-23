package com.ipcoding.guesstheword.feature.data.repository

import com.ipcoding.guesstheword.feature.data.data_source.LetterDao
import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import kotlinx.coroutines.flow.Flow

class LetterRepositoryImpl(
    private val dao: LetterDao
    ) : LetterRepository {

    override suspend fun insertLetter(letter: Letter) {
        dao.insertLetter(letter)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override fun getLetters(): Flow<List<Letter>> {
        return dao.getLetters()
    }

    override suspend fun getLetter(row: Int, column: Int): String {
        return dao.getLetter(row, column)
    }
}