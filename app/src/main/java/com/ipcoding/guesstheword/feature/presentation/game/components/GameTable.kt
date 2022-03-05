package com.ipcoding.guesstheword.feature.presentation.game.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.guesstheword.core.util.TestTags.GAME_TABLE
import com.ipcoding.guesstheword.feature.presentation.game.GameViewModel
import com.ipcoding.guesstheword.ui.theme.AppTheme
import com.ipcoding.guesstheword.ui.theme.Colors

@Composable
fun GameTable(
    viewModel: GameViewModel = hiltViewModel(),
    gameNumber: Int,
    maxWidth: Dp,
    style: TextStyle,
    padding: Dp
) {
    val currentLetter = viewModel.currentLetter.value
    val currentRow = viewModel.currentRow.value
    val letters = viewModel.letters.value

    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.testTag(GAME_TABLE)
    ) {
        items(letters.size / gameNumber) { item1 ->
            LazyRow(modifier = Modifier) {
                items(gameNumber) { item2 ->

                    if (letters.isNotEmpty()) {

                        val letter = letters[item1 * gameNumber + item2]

                        val borderColor = if (
                            currentLetter == item2 && currentRow == item1
                        ) {
                            if (letter.color == Colors.Error.toArgb())
                                Colors.Red else Colors.Gray
                        } else Color(letter.color)

                        OneLetter(
                            text = letter.text,
                            textColor = letter.color,
                            borderColor = borderColor,
                            size = maxWidth / gameNumber,
                            style = style,
                            padding = padding,
                            borderWidth = AppTheme.dimensions.spaceExtraSmall,
                            shape = AppTheme.customShapes.roundedCornerShapeMedium,
                            onClick = {
                                viewModel.selectCurrentLetter(item2, item1)
                            }
                        )
                    }
                }
            }
        }
    }
}