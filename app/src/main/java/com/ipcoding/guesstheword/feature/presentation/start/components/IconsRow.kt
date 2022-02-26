package com.ipcoding.guesstheword.feature.presentation.start.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.InsertChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun IconsRow(
    onChangeThemeClick: () -> Unit,
    onStatsClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = onChangeThemeClick,
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.DarkMode,
                contentDescription = stringResource(id = R.string.change_mode_icon),
                modifier = Modifier.size(AppTheme.dimensions.spaceLarge),
                tint = AppTheme.colors.primary
            )
        }

        IconButton(
            onClick = onStatsClick,
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.InsertChart,
                contentDescription = stringResource(id = R.string.change_mode_icon),
                modifier = Modifier.size(AppTheme.dimensions.spaceLarge),
                tint = AppTheme.colors.primary
            )
        }
    }
}