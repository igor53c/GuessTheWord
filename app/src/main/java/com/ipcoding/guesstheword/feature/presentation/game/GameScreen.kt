package com.ipcoding.guesstheword.feature.presentation.game

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.guesstheword.feature.presentation.game.components.*
import com.ipcoding.guesstheword.ui.theme.AppTheme
import com.ipcoding.guesstheword.feature.presentation.util.Screen

@Composable
fun GameScreen(
    navController: NavController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val defaultDimension = AppTheme.dimensions.default
    val maxWidth = remember { mutableStateOf(defaultDimension) }
    val style = remember { mutableStateOf(TextStyle.Default) }
    val padding = remember { mutableStateOf(defaultDimension) }
    val isScreenVisible = remember { mutableStateOf(true) }
    val handleOnBackPressed = remember { mutableStateOf(false) }
    val isWordCorrect  = viewModel.isWordCorrect.value
    val isEndOfGame  = viewModel.isEndOfGame.value
    val guessingWord  = viewModel.guessingWord.value
    val gameNumber  = viewModel.gameNumber.value
    val wordIsInDictionary  = viewModel.wordIsInDictionary.value

    when(gameNumber) {
        4 -> {
            style.value = AppTheme.typography.h2
            padding.value = AppTheme.dimensions.spaceExtraSmall
        }
        5 -> {
            style.value = AppTheme.typography.h3
            padding.value = AppTheme.dimensions.spaceExtraSmall
        }
        6 -> {
            style.value = AppTheme.typography.h4
            padding.value = AppTheme.dimensions.spaceSuperSmall
        }
        7 -> {
            style.value = AppTheme.typography.h4
            padding.value = AppTheme.dimensions.spaceSuperSmall
        }
    }

    if(isScreenVisible.value) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = AppTheme.dimensions.spaceSmall,
                    start = AppTheme.dimensions.spaceSmall,
                    end = AppTheme.dimensions.spaceSmall
                )
        ) {
            BoxWithConstraints(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = AppTheme.dimensions.spaceSmall),
                contentAlignment = Alignment.TopCenter
            ) {
                maxWidth.value = this.maxWidth

                Column {

                    GameTable(
                        gameNumber = gameNumber,
                        maxWidth = maxWidth.value,
                        style = style.value,
                        padding = padding.value
                    )

                    ErrorText(wordIsInDictionary = wordIsInDictionary)
                }

                Box(modifier = Modifier.align(alignment = Alignment.BottomCenter)) {

                    when {
                        isEndOfGame -> {
                            if(isWordCorrect) {
                                isScreenVisible.value = false
                                viewModel.resetIsEndOfGame()
                                navController.navigate(Screen.StatisticsScreen.route)
                            } else {
                                CorrectWord(
                                    guessingWord = guessingWord,
                                    onClick = {
                                        isScreenVisible.value = false
                                        viewModel.resetIsEndOfGame()
                                        navController.navigate(Screen.StatisticsScreen.route)
                                    }
                                )
                            }
                        }
                        handleOnBackPressed.value -> {
                            ExitQuestion(
                                onYesClick = {
                                    isScreenVisible.value = false
                                    handleOnBackPressed.value = false
                                    navController.navigate(Screen.StartScreen.route)
                                },
                                onNoClick = {
                                    handleOnBackPressed.value = false
                                }
                            )
                        }
                        else -> {
                            Keyboard(maxWidth = maxWidth.value)
                        }
                    }
                }
            }
        }
    }

    BackHandler(true) {
        handleOnBackPressed.value = true
    }
}
