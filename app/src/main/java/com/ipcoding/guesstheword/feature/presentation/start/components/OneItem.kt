package com.ipcoding.guesstheword.feature.presentation.start.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.guesstheword.feature.presentation.util.Screen
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun OneItem(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = AppTheme.colors.primary,
            textAlign = TextAlign.Center,
            style = AppTheme.typography.h2,
            modifier = Modifier
                .clickable {
                    onClick()
                }
        )
    }
}