package com.ipcoding.guesstheword.feature.presentation.start

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.guesstheword.core.util.Constants.TYPES_OF_GAMES
import com.ipcoding.guesstheword.feature.presentation.start.components.ChooseGameButton
import com.ipcoding.guesstheword.feature.presentation.start.components.IconsRow
import com.ipcoding.guesstheword.feature.presentation.start.components.OneItem
import com.ipcoding.guesstheword.feature.presentation.util.Screen
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun StartScreen(
    navController: NavController,
    viewModel: StartViewModel = hiltViewModel(),
    onChangeThemeClick: () -> Unit
) {
    val isDatabaseReady = viewModel.isDatabaseReady.value
    val isDarkTheme = viewModel.isDarkTheme.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = AppTheme.dimensions.spaceMedium),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val expanded = remember { mutableStateOf(false) }
        val isEverythingGone = remember { mutableStateOf(false) }

        IconsRow(
            onChangeThemeClick = {
                viewModel.saveIsDarkTheme()
                onChangeThemeClick()
            },
            onStatsClick = { navController.navigate(Screen.StatisticsScreen.route) },
            isDarkTheme = isDarkTheme,
            onInfoClick = {
                isEverythingGone.value = true
                navController.navigate(Screen.InfoScreen.route)
            }
        )

        AnimatedVisibility(
            visible = expanded.value && !isEverythingGone.value,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = { -it / 2 }),
            exit = fadeOut() + slideOutHorizontally(targetOffsetX = { -it / 2 }),
            modifier = Modifier.weight(1f),
        ) {
            OneItem(
                modifier = Modifier.fillMaxSize(),
                text = TYPES_OF_GAMES[0],
                onClick = {
                    isEverythingGone.value = true
                    viewModel.saveRandomWord(4)
                }
            )
        }

        AnimatedVisibility(
            visible = expanded.value && !isEverythingGone.value,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = { it / 2 }),
            exit = fadeOut() + slideOutHorizontally(targetOffsetX = { it / 2 }),
            modifier = Modifier.weight(1f),
        ) {
            OneItem(
                modifier = Modifier.fillMaxSize(),
                text = TYPES_OF_GAMES[1],
                onClick = {
                    isEverythingGone.value = true
                    viewModel.saveRandomWord(5)
                }
            )
        }

        AnimatedVisibility(
            visible = !isEverythingGone.value,
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.weight(1f),
        ) {
            ChooseGameButton(
                modifier = Modifier.fillMaxSize(),
                onClick = { expanded.value = !expanded.value }
            )
        }

        AnimatedVisibility(
            visible = expanded.value && !isEverythingGone.value,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = { -it / 2 }),
            exit = fadeOut() + slideOutHorizontally(targetOffsetX = { -it / 2 }),
            modifier = Modifier.weight(1f),
        ) {
            OneItem(
                modifier = Modifier.fillMaxSize(),
                text = TYPES_OF_GAMES[2],
                onClick = {
                    isEverythingGone.value = true
                    viewModel.saveRandomWord(6)
                }
            )
        }

        AnimatedVisibility(
            visible = expanded.value && !isEverythingGone.value,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = { it / 2 }),
            exit = fadeOut() + slideOutHorizontally(targetOffsetX = { it / 2 }),
            modifier = Modifier.weight(1f),
        ) {
            OneItem(
                modifier = Modifier.fillMaxSize(),
                text = TYPES_OF_GAMES[3],
                onClick = {
                    isEverythingGone.value = true
                    viewModel.saveRandomWord(7)
                }
            )
        }

        if (isDatabaseReady) {
            viewModel.databaseIsReady()
            navController.navigate(Screen.GameScreen.route)
        }
    }
}