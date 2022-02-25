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
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
) : ViewModel() {

    private var _gameNumber = mutableStateOf(5)
    val gameNumber: State<Int> = _gameNumber

    private var _guessingWord = mutableStateOf("")
    val guessingWord: State<String> = _guessingWord

    private var _wordIsCorrect = mutableStateOf(false)
    val wordIsCorrect: State<Boolean> = _wordIsCorrect

    private var pressedEnter = mutableStateOf(false)

    private var _wordIsInDictionary = mutableStateOf(true)
    val wordIsInDictionary: State<Boolean> = _wordIsInDictionary

    private var  _currentLetter = mutableStateOf(0)
    val currentLetter: State<Int> = _currentLetter

    private var  _currentRow = mutableStateOf(0)
    val currentRow: State<Int> = _currentRow

    private val _letters = mutableStateOf<List<Letter>>(emptyList())
    val letters: State<List<Letter>> = _letters

    private val _keyboardLetters = mutableStateOf<List<Letter>>(emptyList())
    val keyboardLetters: State<List<Letter>> = _keyboardLetters

    private var getLettersJob: Job? = null

    private var getKeyboardLettersJob: Job? = null
    private var wordIsInDictionaryJob: Job? = null

    init {
        getLetters()
        getKeyboardLetters()
        loadRandomWord()
    }

    private fun loadRandomWord() {
        _guessingWord.value = preferences.loadRandomWord().toString()
        _gameNumber.value = _guessingWord.value.length
    }

    fun saveLetter(letter: String) {
        viewModelScope.launch {
            allUseCases.saveLetter(
                char = letter,
                row = currentRow.value,
                column = currentLetter.value,
                number = gameNumber.value
            )
        }
        positionCurrentLetter()
    }

    private fun positionCurrentLetter() {
        _currentLetter.value =
            allUseCases.positionCurrentLetter(
                row = currentRow.value,
                position = currentLetter.value,
                letters = letters.value,
                number = gameNumber.value
            )
    }

    fun checkAllLettersEntered() {
        if(!pressedEnter.value) {
            pressedEnter.value = true
            val waitJob = viewModelScope.launch {
                delay(500L)
            }
            viewModelScope.launch {
                if(allUseCases.checkAllLettersEntered(
                        row = currentRow.value,
                        letters = letters.value,
                        number = gameNumber.value
                    )) {
                    checkWordInDictionary()
                } else forcedComposing()

                waitJob.join()
                pressedEnter.value = false
            }
        }
    }

    private suspend fun checkWordInDictionary() {
        if(allUseCases.checkWordInDictionary(
                row = currentRow.value,
                letters = letters.value,
                number = gameNumber.value
            )) {
            checkIfWordIsCorrect()
            _wordIsInDictionary.value = true
        } else {
            _wordIsInDictionary.value = true
            delay(100L)
            _wordIsInDictionary.value = false
            wordIsInDictionaryJob?.cancel()
            wordIsInDictionaryJob = viewModelScope.launch {
                repeat(10) {
                    if(isActive) delay(500L)
                }
                _wordIsInDictionary.value = true
            }
        }
    }

    private suspend fun checkIfWordIsCorrect() {
        _wordIsCorrect.value = allUseCases.checkIfWordIsCorrect(
            guessingWord = guessingWord.value,
            row = currentRow.value,
            number = gameNumber.value
        )
        if(currentRow.value == (gameNumber.value - 1)) {
            _currentLetter.value = -1
            _wordIsCorrect.value = true
        } else {
            _currentLetter.value = 0
            _currentRow.value = currentRow.value + 1
        }
    }

    private fun forcedComposing() {
        val list = mutableListOf<Letter>()
        list.addAll(letters.value)
        list.add(Letter(row = -1, column = -1))
        _letters.value = list
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

    private fun getKeyboardLetters() {
        getKeyboardLettersJob?.cancel()
        getKeyboardLettersJob = allUseCases.getKeyboardLetters()
            .onEach { items ->
                _keyboardLetters.value = items
            }
            .launchIn(viewModelScope)
    }

    fun deleteCurrentLetter() {
        viewModelScope.launch {
            _currentLetter.value = allUseCases.deleteCurrentLetter(
                row = currentRow.value,
                column = currentLetter.value,
                letters = letters.value,
                number = gameNumber.value
            )
        }
        forcedComposing()
    }
}