package com.ipcoding.guesstheword.feature.presentation.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun CorrectWord(
    guessingWord: String,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .background(
                color = AppTheme.colors.primary,
                shape = AppTheme.customShapes.roundedCornerShapeSmall
            )
            .padding(AppTheme.dimensions.spaceMedium)
    ) {
        Text(
            text = stringResource(id = R.string.guessing_word) + "  $guessingWord",
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            color = AppTheme.colors.background,
            style = AppTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceMedium))

        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AppTheme.colors.background
            )
        ) {
            Text(
                text = stringResource(id = R.string.ok),
                style = AppTheme.typography.body1,
                color = AppTheme.colors.primary
            )
        }
    }
}