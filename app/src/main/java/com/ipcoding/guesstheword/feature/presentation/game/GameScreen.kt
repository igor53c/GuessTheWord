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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.guesstheword.feature.presentation.game.components.OneLetter
import com.ipcoding.guesstheword.ui.theme.AppTheme
import com.ipcoding.guesstheword.feature.presentation.game.components.Keyboard
import com.ipcoding.guesstheword.feature.presentation.util.Screen
import com.ipcoding.guesstheword.ui.theme.Colors

@Composable
fun GameScreen(
    navController: NavController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val maxWidth = remember { mutableStateOf(0.dp) }
    val currentLetter  = viewModel.currentLetter.value
    val currentRow  = viewModel.currentRow.value
    val letters  = viewModel.letters.value
    val wordIsCorrect  = viewModel.wordIsCorrect.value
    val guessingWord  = viewModel.guessingWord.value
    val wordIsInDictionary  = viewModel.wordIsInDictionary.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(AppTheme.dimensions.spaceSmall)
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = AppTheme.dimensions.spaceSmall),
            contentAlignment = Alignment.TopCenter
        ) {
            maxWidth.value = this.maxWidth

            LazyColumn(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
            ) {
                items(letters.size / 5) { item1 ->
                    LazyRow(modifier = Modifier) {
                        items(5) { item2 ->

                            if(letters.isNotEmpty()) {

                                val letter = letters[item1 * 5 + item2]

                                val borderColor =
                                    if(currentLetter == item2 && currentRow == item1) {
                                    if(letter.color == Colors.Error.toArgb())
                                        Colors.Red else Colors.Gray
                                } else Color(letter.color)

                                OneLetter(
                                    text = letter.text,
                                    textColor = Color(letter.color),
                                    borderColor = borderColor,
                                    size = maxWidth.value / 5,
                                    style = AppTheme.typography.h3,
                                    padding = AppTheme.dimensions.spaceExtraSmall,
                                    borderWidth = AppTheme.dimensions.spaceExtraSmall,
                                    shape = AppTheme.customShapes.roundedCornerShapeMedium,
                                    onClick = { viewModel.selectCurrentLetter(item2, item1) }
                                )
                            }
                        }
                    }
                }
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