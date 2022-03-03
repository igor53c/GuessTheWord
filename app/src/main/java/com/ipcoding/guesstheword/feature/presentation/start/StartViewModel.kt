package com.ipcoding.guesstheword.feature.presentation.start

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.guesstheword.core.domain.preferences.Preferences
import com.ipcoding.guesstheword.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
) : ViewModel() {

    private var _isDatabaseReady = mutableStateOf(false)
    val isDatabaseReady: State<Boolean> = _isDatabaseReady

    private var _isDarkTheme = mutableStateOf(false)
    val isDarkTheme: State<Boolean> = _isDarkTheme

    init {
        loadIsDarkTheme()
    }

    fun databaseIsReady() {
        _isDatabaseReady.value = false
    }

    private fun loadIsDarkTheme() {
        _isDarkTheme.value = preferences.loadIsDarkTheme()
    }

    fun saveIsDarkTheme() {
        _isDarkTheme.value = !isDarkTheme.value
        preferences.saveIsDarkTheme(isDarkTheme.value)
    }

    fun saveRandomWord(number: Int) {
        allUseCases.saveRandomWord(number)
        viewModelScope.launch {
            _isDatabaseReady.value = allUseCases.createDatabase(number)
        }
    }
}