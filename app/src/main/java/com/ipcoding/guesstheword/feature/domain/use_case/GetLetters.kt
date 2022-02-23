package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import kotlinx.coroutines.flow.Flow

class GetLetters(
    private val letterRepository: LetterRepository
) {

    operator fun invoke() : Flow<List<Letter>> {
        return letterRepository.getLetters()
    }
}