package com.ipcoding.guesstheword.feature.presentation.game

import androidx.lifecycle.ViewModel
import com.ipcoding.guesstheword.core.domain.preferences.Preferences
import com.ipcoding.guesstheword.feature.domain.use_case.AllUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {

}