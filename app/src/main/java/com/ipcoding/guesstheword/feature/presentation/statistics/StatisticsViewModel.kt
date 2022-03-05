package com.ipcoding.guesstheword.feature.presentation.statistics

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ipcoding.guesstheword.feature.domain.use_case.AllUseCases
import com.ipcoding.guesstheword.feature.domain.util.Stats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val allUseCases: AllUseCases
) : ViewModel() {

    private var _stats = mutableStateOf<List<Stats>>(emptyList())
    val stats: State<List<Stats>> = _stats

    init {
        getStats()
    }

    private fun getStats() {
        viewModelScope.launch {
            _stats.value = allUseCases.getStats()
        }
    }
}