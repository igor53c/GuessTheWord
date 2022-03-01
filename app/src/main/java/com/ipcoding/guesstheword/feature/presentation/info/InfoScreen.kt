package com.ipcoding.guesstheword.feature.presentation.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.feature.presentation.info.components.InfoRow
import com.ipcoding.guesstheword.ui.theme.AppTheme
import com.ipcoding.guesstheword.ui.theme.Colors

@Composable
fun InfoScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = AppTheme.dimensions.spaceLarge,
                bottom = AppTheme.dimensions.spaceSmall,
                start = AppTheme.dimensions.spaceSmall,
                end = AppTheme.dimensions.spaceSmall,
            )
    ) {
        Text(
            text = stringResource(id = R.string.guess_the_word),
            style = AppTheme.typography.h5,
            color = AppTheme.colors.primary,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppTheme.dimensions.spaceMedium)
        )

        Text(
            text = stringResource(id = R.string.you_must_enter_valid_word),
            style = AppTheme.typography.h5,
            color = AppTheme.colors.primary,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppTheme.dimensions.spaceMedium)
        )

        Text(
            text = stringResource(id = R.string.after_guess),
            style = AppTheme.typography.h5,
            color = AppTheme.colors.primary,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = AppTheme.dimensions.spaceLarge)
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
}