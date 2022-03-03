package com.ipcoding.guesstheword.feature.presentation.statistics.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun ProgressBar(
    modifier: Modifier,
    cornerRadius: Float,
    progress: Float,
    color: Color
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(AppTheme.dimensions.spaceMedium),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
        ) {
            val canvasWidth = size.width
            val canvasHeight = size.height

            drawRoundRect(
                color = color.copy(alpha = 0.5f),
                topLeft = Offset(0f, 0f),
                size = Size(canvasWidth, canvasHeight),
                cornerRadius = CornerRadius(cornerRadius, cornerRadius),
            )

            if (progress >= 0f)
                drawRoundRect(
                    color = color,
                    topLeft = Offset(0f, 0f),
                    size = Size(canvasWidth * progress, canvasHeight),
                    cornerRadius = CornerRadius(cornerRadius, cornerRadius),
                )
        }
    }
}