package com.ipcoding.guesstheword.feature.presentation.start

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.guesstheword.feature.presentation.start.components.ChooseGameButton
import com.ipcoding.guesstheword.feature.presentation.start.components.IconsRow
import com.ipcoding.guesstheword.feature.presentation.start.components.OneItem
import com.ipcoding.guesstheword.feature.presentation.util.Screen
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun StartScreen (
    navController: NavController,
    viewModel: StartViewModel = hiltViewModel(),
    onChangeThemeClick: () -> Unit
) {
    val isDatabaseReady = viewModel.isDatabaseReady.value
    val isDarkTheme = viewModel.isDarkTheme.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.dimensions.spaceMedium),
       horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val expanded = remember { mutableStateOf(false) }

        IconsRow(
            onChangeThemeClick = {
                viewModel.saveIsDarkTheme()
                onChangeThemeClick()
            },
            onStatsClick = { navController.navigate(Screen.StatisticsScreen.route) },
            isDarkTheme = isDarkTheme
        )

        AnimatedVisibility(
            visible = expanded.value,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = { -it / 2}),
            exit = fadeOut() + slideOutHorizontally(targetOffsetX = { -it / 2}),
            modifier = Modifier.weight(1f),
        ) {
            OneItem(
                modifier = Modifier.fillMaxSize(),
                text = "4 x 4",
                onClick = { viewModel.saveRandomWord(4) }
            )
        }

        AnimatedVisibility(
            visible = expanded.value,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = { it / 2}),
            exit = fadeOut() + slideOutHorizontally(targetOffsetX = { it / 2}),
            modifier = Modifier.weight(1f),
        ) {
            OneItem(
                modifier = Modifier.fillMaxSize(),
                text = "5 x 5",
                onClick = { viewModel.saveRandomWord(5) }
            )
        }

        ChooseGameButton(
            modifier = Modifier.weight(1f),
            onClick = { expanded.value = !expanded.value }
        )

        AnimatedVisibility(
            visible = expanded.value,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = { -it / 2}),
            exit = fadeOut() + slideOutHorizontally(targetOffsetX = { -it / 2}),
            modifier = Modifier.weight(1f),
        ) {
            OneItem(
                modifier = Modifier.fillMaxSize(),
                text = "6 x 6",
                onClick = { viewModel.saveRandomWord(6) }
            )
        }

        AnimatedVisibility(
            visible = expanded.value,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = { it / 2}),
            exit = fadeOut() + slideOutHorizontally(targetOffsetX = { it / 2}),
            modifier = Modifier.weight(1f),
        ) {
            OneItem(
                modifier = Modifier .fillMaxSize(),
                text = "7 x 7",
                onClick = { viewModel.saveRandomWord(7) }
            )
        }

        if(isDatabaseReady) {
            viewModel.databaseIsReady()
            navController.navigate(Screen.GameScreen.route)
        }
    }
}