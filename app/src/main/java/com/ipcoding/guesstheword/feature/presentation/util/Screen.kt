package com.ipcoding.guesstheword.feature.presentation.util

sealed class Screen(val route: String) {
    object GameScreen: Screen("game_screen")
}
