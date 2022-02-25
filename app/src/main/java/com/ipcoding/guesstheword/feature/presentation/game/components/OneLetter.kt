package com.ipcoding.guesstheword.feature.presentation.game.components

import androidx.compose.animation.*
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

@Composable
fun OneLetter(
    text: String,
    textColor: Int,
    borderColor: Color,
    size: Dp,
    padding: Dp,
    style: TextStyle,
    borderWidth: Dp,
    shape: Shape,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(size = size)
            .padding(padding)
            .clickable { onClick() }
    ) {
       AnimatedVisibility(
            visible = textColor != 0,
            enter = fadeIn() + slideInHorizontally(initialOffsetX = { it / 2}),
            exit = fadeOut()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(
                        width = borderWidth,
                        color = borderColor,
                        shape = shape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    color = Color(textColor),
                    style = style
                )
            }
        }
    }
}