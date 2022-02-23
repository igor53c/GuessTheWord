package com.ipcoding.guesstheword.feature.presentation.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.window.DialogProperties
import com.ipcoding.guesstheword.ui.theme.AppTheme
import com.ipcoding.guesstheword.R

@Composable
fun QuestionDialog(
    currentWord: String,
    onNoClick: () -> Unit,
    onYesClick: () -> Unit
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
            text = stringResource(id = R.string.your_word) + "  " + currentWord,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = AppTheme.colors.background,
            style = AppTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = onYesClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppTheme.colors.background
                )
            ) {
                Text(
                    text = stringResource(id = R.string.yes),
                    style = AppTheme.typography.body1,
                    color = AppTheme.colors.primary
                )
            }

            Spacer(modifier = Modifier.width(AppTheme.dimensions.spaceSmall))

            Button(
                modifier = Modifier
                    .weight(1f),
                onClick = onNoClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = AppTheme.colors.background
                )
            ) {
                Text(
                    text = stringResource(id = R.string.no),
                    style = AppTheme.typography.body1,
                    color = AppTheme.colors.primary
                )
            }
        }
    }
}