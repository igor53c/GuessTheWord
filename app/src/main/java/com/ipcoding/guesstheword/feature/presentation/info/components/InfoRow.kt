package com.ipcoding.guesstheword.feature.presentation.info.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.guesstheword.feature.presentation.game.components.OneLetter
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun InfoRow(
    text: String,
    textColor: Color,
    borderColor: Color
) {
    Row(
        modifier = Modifier
            .padding(bottom = AppTheme.dimensions.spaceMedium)
            .height(AppTheme.dimensions.spaceExtraLarge)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OneLetter(
            text = "R",
            textColor = textColor.toArgb(),
            borderColor = borderColor,
            size = AppTheme.dimensions.spaceExtraLarge,
            padding = AppTheme.dimensions.default,
            style = AppTheme.typography.h4,
            borderWidth = AppTheme.dimensions.spaceExtraSmall,
            shape = AppTheme.customShapes.roundedCornerShapeMedium
        ) {}
        Text(
            text = text,
            style = AppTheme.typography.h5,
            color = AppTheme.colors.primary,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(start = AppTheme.dimensions.spaceSmall)
                .weight(1f)
        )
    }
}