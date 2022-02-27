package com.ipcoding.guesstheword.feature.presentation.start.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun ChooseGameButton(
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Button(
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(AppTheme.dimensions.spaceMedium),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = AppTheme.colors.primary
            ),
            shape = AppTheme.customShapes.roundedCornerShapeMedium
        ) {
            Text(
                text = stringResource(id = R.string.choose_game),
                color = AppTheme.colors.background,
                style = AppTheme.typography.h4,
                textAlign = TextAlign.Center,
                modifier = Modifier
            )
        }
    }
}