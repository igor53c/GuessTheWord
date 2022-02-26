package com.ipcoding.guesstheword.feature.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ipcoding.guesstheword.core.domain.preferences.Preferences
import com.ipcoding.guesstheword.feature.presentation.game.GameScreen
import com.ipcoding.guesstheword.feature.presentation.start.StartScreen
import com.ipcoding.guesstheword.feature.presentation.statistics.StatisticsScreen
import com.ipcoding.guesstheword.feature.presentation.util.Screen
import com.ipcoding.guesstheword.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject lateinit var preferences: Preferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val darkTheme = remember { mutableStateOf(preferences.loadIsDarkTheme()) }

            AppTheme(darkTheme = darkTheme.value) {
                Surface(
                    color = AppTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val systemUiController = rememberSystemUiController()
                    systemUiController.isStatusBarVisible = false
                    NavHost(
                        navController = navController,
                        startDestination = Screen.StartScreen.route
                    ) {
                        composable(route = Screen.GameScreen.route) {
                            GameScreen(navController = navController)
                        }
                        composable(route = Screen.StartScreen.route) {
                            StartScreen(
                                navController = navController,
                                onChangeThemeClick = { darkTheme.value = !darkTheme.value }
                            )
                            BackHandler(true) {}
                        }
                        composable(route = Screen.StatisticsScreen.route) {
                            StatisticsScreen(navController = navController)
                            BackHandler(true) {
                                navController.navigate(Screen.StartScreen.route)
                            }
                        }
                    }
                }
            }
        }
    }
}