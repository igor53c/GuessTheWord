package com.ipcoding.guesstheword.feature.presentation.game_stats.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun InfoText(
    explanation: String,
    value: String,
    padding: Dp = AppTheme.dimensions.default
) {
    Text(
        text = "$explanation  $value",
        color = AppTheme.colors.primary,
        style = AppTheme.typography.h4,
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = padding)
    )
}