package com.ipcoding.guesstheword.feature.data.repository

import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeLetterRepository : LetterRepository {

    private var letters = mutableListOf<Letter>()

    override suspend fun insertLetter(letter: Letter) {
        if (letter.id == null) {
            letter.id = letters.size + 1
            letters.add(letter)
        } else {
            letters[letter.id!! - 1] = letter
        }
    }

    override suspend fun deleteLetter(letter: Letter) {
        letters.remove(letter)
    }

    override suspend fun deleteAll() {
        letters.clear()
    }

    override fun getLettersFlow(): Flow<List<Letter>> {
        return flow { emit(letters.filter { !it.isKeyboard }.sortedBy { it.id }) }
    }

    override fun getKeyboardLettersFlow(): Flow<List<Letter>> {
        return flow { emit(letters.filter { it.isKeyboard }.sortedBy { it.id }) }
    }

    override suspend fun getLetters(): List<Letter> {
        return letters.filter { !it.isKeyboard }.sortedBy { it.id }
    }

    override suspend fun getLetter(row: Int, column: Int): String {
        return letters.find { it.row == row && it.column == column }?.text ?: ""
    }

    override suspend fun getKeyboardLetter(text: String): Letter {
        return letters.filter { it.isKeyboard && it.text == text }[0]
    }
}