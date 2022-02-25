package com.ipcoding.guesstheword.feature.presentation.game

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.guesstheword.feature.presentation.game.components.OneLetter
import com.ipcoding.guesstheword.ui.theme.AppTheme
import com.ipcoding.guesstheword.feature.presentation.game.components.Keyboard
import com.ipcoding.guesstheword.feature.presentation.util.Screen
import com.ipcoding.guesstheword.ui.theme.Colors
import com.ipcoding.guesstheword.feature.presentation.game.components.ErrorText

@Composable
fun GameScreen(
    navController: NavController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val defaultDimension = AppTheme.dimensions.default
    val maxWidth = remember { mutableStateOf(defaultDimension) }
    val style = remember { mutableStateOf(TextStyle.Default) }
    val padding = remember { mutableStateOf(defaultDimension) }
    val currentLetter  = viewModel.currentLetter.value
    val currentRow  = viewModel.currentRow.value
    val letters  = viewModel.letters.value
    val wordIsCorrect  = viewModel.wordIsCorrect.value
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
                LazyColumn(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                ) {
                    items(letters.size / gameNumber) { item1 ->
                        LazyRow(modifier = Modifier) {
                            items(gameNumber) { item2 ->

                                if(letters.isNotEmpty()) {

                                    val letter = letters[item1 * gameNumber + item2]

                                    val borderColor = if(
                                        currentLetter == item2 && currentRow == item1
                                    ) {
                                        if(letter.color == Colors.Error.toArgb())
                                            Colors.Red else Colors.Gray
                                    } else Color(letter.color)

                                    OneLetter(
                                        text = letter.text,
                                        textColor = letter.color,
                                        borderColor = borderColor,
                                        size = maxWidth.value / gameNumber,
                                        style = style.value,
                                        padding = padding.value,
                                        borderWidth = AppTheme.dimensions.spaceExtraSmall,
                                        shape = AppTheme.customShapes.roundedCornerShapeMedium,
                                        onClick = { viewModel.selectCurrentLetter(item2, item1) }
                                    )
                                }
                            }
                        }
                    }
                }

                ErrorText(wordIsInDictionary = wordIsInDictionary)
            }

            Box(modifier = Modifier.align(alignment = Alignment.BottomCenter)) {

                if(wordIsCorrect) {
                    Button(
                        onClick = { navController.navigate(Screen.StartScreen.route) },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = AppTheme.colors.primary,
                            contentColor = AppTheme.colors.background
                        )
                    ) {
                        Text(text = guessingWord)
                    }
                } else {
                    Keyboard(maxWidth = maxWidth.value)
                }
            }
        }
    }
}