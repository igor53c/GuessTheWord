package com.ipcoding.guesstheword.feature.presentation.statistics.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.guesstheword.ui.theme.AppTheme
import kotlinx.coroutines.delay
import kotlin.math.round

@Composable
fun OneRow(
    number: Int,
    progress: Float
) {
    val targetProgress = remember { mutableStateOf(0f) }
    val animatedProgress = animateFloatAsState(targetValue = targetProgress.value)

    LaunchedEffect(true) {
        delay(200)
        while (targetProgress.value < progress) {
            targetProgress.value += 0.001f
            delay(1)
        }
    }

    Row(
        modifier = Modifier
            .height(AppTheme.dimensions.spaceExtraLarge)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$number x $number",
            color = AppTheme.colors.primary,
            style = AppTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceLarge)
        )

        ProgressBar(
            modifier = Modifier.weight(1f),
            cornerRadius = AppTheme.dimensions.spaceExtraMedium.value,
            progress = animatedProgress.value,
            color = AppTheme.colors.primary
        )

        Text(
            text = "${round(animatedProgress.value * 100).toInt()}%",
            color = AppTheme.colors.primary,
            style = AppTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .width(AppTheme.dimensions.spaceLarge)
        )
    }
}