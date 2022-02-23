package com.ipcoding.guesstheword.feature.presentation.game

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.guesstheword.core.util.Constants.ALL_LETTERS
import com.ipcoding.guesstheword.feature.presentation.game.components.OneLetter
import com.ipcoding.guesstheword.feature.presentation.game.components.QuestionDialog
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun GameScreen(
    navController: NavController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val maxWidth = remember { mutableStateOf(0.dp) }
    val currentLetter  = viewModel.currentLetter.value
    val currentRow  = viewModel.currentRow.value
    val letters  = viewModel.letters.value
    val currentWord = viewModel.currentWord.value

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

            Column() {
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                ) {
                    items(5) { item1 ->
                        LazyRow(modifier = Modifier) {
                            items(5) { item2 ->
                                val backgroundColor = if(currentLetter == item2 && currentRow == item1)
                                    AppTheme.colors.secondary else AppTheme.colors.background

                                val text = if(letters.isEmpty()) "" else
                                    letters[item1 * 5 + item2].text
                                OneLetter(
                                    text = text,
                                    textColor = AppTheme.colors.primary,
                                    size = maxWidth.value / 5,
                                    style = AppTheme.typography.h3,
                                    backgroundColor = backgroundColor,
                                    padding = AppTheme.dimensions.spaceExtraSmall,
                                    borderWidth = AppTheme.dimensions.spaceExtraSmall,
                                    shape = AppTheme.customShapes.roundedCornerShapeMedium,
                                    onClick = { viewModel.changeTheCurrentLetter(item2, item1) }
                                )
                            }
                        }
                    }
                }

                Box(modifier = Modifier.weight(1f)) {
                    Log.d("kontrola", currentWord)
                    if (currentWord.length == 5) {
                        QuestionDialog(
                            currentWord = currentWord,
                            onNoClick = {
                                viewModel.resetCurrentWordHasAllLetters()
                            },
                            onYesClick = {
                                viewModel.resetCurrentWordHasAllLetters()
                            }
                        )
                    }
                }
                    LazyColumn(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                    ) {
                        items(3) { item1 ->
                            LazyRow(modifier = Modifier) {
                                items(9) { item2 ->

                                    val char = ALL_LETTERS[item1 * 9 + item2]
                                    OneLetter(
                                        text = char,
                                        textColor = AppTheme.colors.primary,
                                        size = maxWidth.value / 9,
                                        style = AppTheme.typography.h5,
                                        backgroundColor = AppTheme.colors.background,
                                        padding = AppTheme.dimensions.spaceSuperSmall,
                                        borderWidth = AppTheme.dimensions.spaceSuperSmall,
                                        shape = AppTheme.customShapes.roundedCornerShapeSmall,
                                        onClick = { viewModel.saveLetter(char) }
                                    )
                                }
                            }
                        }
                    }

            }
        }
    }
}