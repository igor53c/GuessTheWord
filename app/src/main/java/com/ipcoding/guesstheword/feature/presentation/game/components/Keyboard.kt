package com.ipcoding.guesstheword.feature.presentation.game.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.core.util.Constants.DURATION_LETTER_ANIMATION
import com.ipcoding.guesstheword.feature.presentation.game.GameViewModel
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun Keyboard(
    maxWidth: Dp,
    viewModel: GameViewModel = hiltViewModel()
) {
    val keyboardLetters = viewModel.keyboardLetters.value

    Row(
        modifier = Modifier.height(maxWidth * 3 / 10)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
        ) {
            items(3) { item1 ->
                LazyRow(modifier = Modifier) {
                    items(9) { item2 ->

                        if (keyboardLetters.isNotEmpty()) {
                            val keyboardLetter = keyboardLetters[item1 * 9 + item2]

                            val color = animateColorAsState(
                                targetValue = Color(keyboardLetter.color),
                                animationSpec = tween(DURATION_LETTER_ANIMATION)
                            ).value

                            OneLetter(
                                text = keyboardLetter.text,
                                textColor = color.toArgb(),
                                borderColor = color,
                                size = maxWidth / 10,
                                style = AppTheme.typography.h5,
                                padding = AppTheme.dimensions.spaceSuperSmall,
                                borderWidth = AppTheme.dimensions.spaceSuperSmall,
                                shape = AppTheme.customShapes.roundedCornerShapeSmall,
                                onClick = { viewModel.saveLetter(keyboardLetter.text) }
                            )
                        }
                    }
                }
            }
        }
        Column {
            KeyboardIcons(
                width = maxWidth / 10,
                height = maxWidth / 10,
                onClick = { viewModel.deleteCurrentLetter() },
                imageVector = Icons.Default.Backspace,
                contentDescription = stringResource(id = R.string.backspace_icon),
            )
            KeyboardIcons(
                width = maxWidth / 10,
                height = maxWidth / 5,
                onClick = { viewModel.checkAllLettersEntered() },
                imageVector = Icons.Default.Send,
                contentDescription = stringResource(id = R.string.enter_icon),
            )
        }
    }
}