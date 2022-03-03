package com.ipcoding.guesstheword.feature.presentation.util

sealed class Screen(val route: String) {
    object GameScreen : Screen("game_screen")
    object StartScreen : Screen("start_screen")
    object StatisticsScreen : Screen("statistics_screen")
    object InfoScreen : Screen("info_screen")
}
