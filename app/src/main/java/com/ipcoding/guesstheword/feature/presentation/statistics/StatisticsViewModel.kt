package com.ipcoding.guesstheword.feature.presentation.statistics

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
class StatisticsViewModel @Inject constructor(
    private val preferences: Preferences,
    private val allUseCases: AllUseCases
) : ViewModel() {

    private var _stats = mutableStateOf<List<Float>>(emptyList())
    val stats: State<List<Float>> = _stats

    init {
        getStats()
    }

    private fun getStats() {
        viewModelScope.launch {
            _stats.value = allUseCases.getStats()
        }
    }
}