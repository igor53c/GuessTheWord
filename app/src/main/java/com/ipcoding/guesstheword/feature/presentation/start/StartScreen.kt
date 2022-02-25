package com.ipcoding.guesstheword.feature.presentation.start

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.ipcoding.guesstheword.feature.presentation.start.components.OneItem
import com.ipcoding.guesstheword.feature.presentation.util.Screen

@Composable
fun StartScreen (
    navController: NavController,
    viewModel: StartViewModel = hiltViewModel()
) {
    val isDatabaseReady = viewModel.isDatabaseReady.value

    Column(
        modifier = Modifier
            .fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OneItem(
            modifier = Modifier.weight(1f),
            text = "4 x 4",
            onClick = { viewModel.saveRandomWord(4) }
        )

        OneItem(
            modifier = Modifier.weight(1f),
            text = "5 x 5",
            onClick = { viewModel.saveRandomWord(5) }
        )

        OneItem(
            modifier = Modifier.weight(1f),
            text = "6 x 6",
            onClick = { viewModel.saveRandomWord(6) }
        )

        OneItem(
            modifier = Modifier.weight(1f),
            text = "7 x 7",
            onClick = { viewModel.saveRandomWord(7) }
        )

        if(isDatabaseReady) {
            viewModel.databaseIsReady()
            navController.navigate(Screen.GameScreen.route)
        }
    }
}