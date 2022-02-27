package com.ipcoding.guesstheword.feature.presentation.start.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
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
        Button(
            onClick =  onClick,
            modifier = Modifier.width(AppTheme.dimensions.spaceSuperLarge * 2),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AppTheme.colors.primary
            ),
            shape = AppTheme.customShapes.roundedCornerShapeMedium
        ) {
            Text(
                text = text,
                color = AppTheme.colors.background,
                textAlign = TextAlign.Center,
                style = AppTheme.typography.h3,
            )
        }
    }
}