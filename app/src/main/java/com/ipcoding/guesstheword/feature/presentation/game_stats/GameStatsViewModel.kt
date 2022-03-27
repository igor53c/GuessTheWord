package com.ipcoding.guesstheword.feature.presentation.game_stats

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.guesstheword.feature.domain.use_case.AllUseCases
import com.ipcoding.guesstheword.feature.domain.util.GameStats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameStatsViewModel @Inject constructor(
    private val allUseCases: AllUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _gameNumber = mutableStateOf(5)
    val gameNumber: State<Int> = _gameNumber

    private var _gameStats = mutableStateOf(GameStats(0, 0, emptyList()))
    val gameStats: State<GameStats> = _gameStats

    init {
        savedStateHandle.get<Int>("gameNumber")?.let { number ->
            if (number != -1) {
                _gameNumber.value = number
            }
        }

        getGameStats()
    }

    private fun getGameStats() {
        viewModelScope.launch {
            _gameStats.value = allUseCases.getGameStats(gameNumber.value)
        }
    }
}