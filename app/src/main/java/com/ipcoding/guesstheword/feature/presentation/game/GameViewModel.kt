package com.ipcoding.guesstheword.feature.presentation.game

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.guesstheword.core.domain.preferences.Preferences
import com.ipcoding.guesstheword.feature.domain.model.Letter
import com.ipcoding.guesstheword.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
) : ViewModel() {

    private var _guessingWord = mutableStateOf("")
    val guessingWord: State<String> = _guessingWord

    private var _wordIsCorrect = mutableStateOf(false)
    val wordIsCorrect: State<Boolean> = _wordIsCorrect

    private var  _currentLetter = mutableStateOf(0)
    val currentLetter: State<Int> = _currentLetter

    private var  _currentRow = mutableStateOf(0)
    val currentRow: State<Int> = _currentRow

    private val _letters = mutableStateOf<List<Letter>>(emptyList())
    val letters: State<List<Letter>> = _letters

    private var getLettersJob: Job? = null

    init {
        _guessingWord.value = "BOKAL"
        getLetters()
    }

    fun saveLetter(letter: String) {
        viewModelScope.launch {
            allUseCases.saveLetter(
                char = letter,
                row = currentRow.value,
                column = currentLetter.value
            )
        }
        positionCurrentLetter()
    }

    private fun positionCurrentLetter() {
        _currentLetter.value =
            allUseCases.positionCurrentLetter(currentRow.value, currentLetter.value, letters.value)
    }

    fun checkIfWordIsCorrect() {
        viewModelScope.launch {
            _wordIsCorrect.value = allUseCases.checkIfWordIsCorrect(
                guessingWord = guessingWord.value,
                row = currentRow.value,
                letters = letters.value
            )
        }
        if(currentRow.value == 4) _wordIsCorrect.value = true else
            _currentRow.value = currentRow.value + 1
        _currentLetter.value = 0
    }

    fun selectCurrentLetter(column: Int, row: Int) {
        if(row == currentRow.value) {
            _currentLetter.value = column
        }
    }

    private fun getLetters() {
        getLettersJob?.cancel()
        getLettersJob = allUseCases.getLetters()
            .onEach { items ->
                _letters.value = items
            }
            .launchIn(viewModelScope)
    }

    fun deleteCurrentLetter() {
        viewModelScope.launch {
            _currentLetter.value = allUseCases.deleteCurrentLetter(
                row = currentRow.value,
                column = currentLetter.value,
                letters = letters.value
            )
        }
    }
}