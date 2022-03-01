package com.ipcoding.guesstheword.feature.presentation.start.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.guesstheword.ui.theme.AppTheme
import com.ipcoding.guesstheword.ui.theme.Colors
import com.ipcoding.guesstheword.R

@Composable
fun InfoDialog(
    dismissButton: () -> Unit
) {
    AlertDialog(
        backgroundColor = AppTheme.colors.background,
        onDismissRequest = { dismissButton() },
        title = {},
        text = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.guess_the_word),
                    style = AppTheme.typography.h6,
                    color = AppTheme.colors.primary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = AppTheme.dimensions.spaceSmall)
                )

                Text(
                    text = stringResource(id = R.string.you_must_enter_valid_word),
                    style = AppTheme.typography.h6,
                    color = AppTheme.colors.primary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = AppTheme.dimensions.spaceSmall)
                )

                Text(
                    text = stringResource(id = R.string.after_guess),
                    style = AppTheme.typography.h6,
                    color = AppTheme.colors.primary,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = AppTheme.dimensions.spaceMedium)
                )
                
                InfoRow(
                    text = stringResource(id = R.string.not_in_word),
                    textColor = Colors.Gray,
                    borderColor = Colors.Gray
                )

                InfoRow(
                    text = stringResource(id = R.string.but_wrong_place),
                    textColor = Colors.Yellow,
                    borderColor = Colors.Yellow
                )

                InfoRow(
                    text = stringResource(id = R.string.in_right_place),
                    textColor = Colors.Green,
                    borderColor = Colors.Green
                )
            }
        },
        buttons = {}
    )
}