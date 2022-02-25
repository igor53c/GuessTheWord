package com.ipcoding.guesstheword.feature.presentation.game.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun ErrorText(
    wordIsInDictionary: Boolean
) {
    Spacer(modifier = Modifier.height(AppTheme.dimensions.spaceMedium))

    AnimatedVisibility(
        visible = !wordIsInDictionary,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Text(
            text = stringResource(id = R.string.not_in_dictionary),
            style = AppTheme.typography.h4,
            color = AppTheme.colors.primary,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}
