package com.ipcoding.guesstheword.feature.domain.util

data class GameStats(
    val totalGamesPlayed: Int,
    val numberOfWins: Int,
    val winsFromAttempts: List<Int>
)
