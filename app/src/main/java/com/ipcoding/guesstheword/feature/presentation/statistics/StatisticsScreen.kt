package com.ipcoding.guesstheword.feature.presentation.statistics

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.feature.presentation.statistics.components.OneRow
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun StatisticsScreen(
    navController: NavController,
    viewModel: StatisticsViewModel = hiltViewModel()
) {
    val stats = viewModel.stats.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = AppTheme.dimensions.spaceMedium,
                start = AppTheme.dimensions.spaceSmall,
                end = AppTheme.dimensions.spaceSmall
            )
    ) {
        Text(
            text = stringResource(id = R.string.guessing_success),
            color = AppTheme.colors.primary,
            style = AppTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {
            items(4) { item ->

                if(stats.isNotEmpty()) {
                    OneRow(
                        number = item + 4,
                        progress = stats[item].guessingSuccess
                    )
                }
            }
        }

        Text(
            text = stringResource(id = R.string.average_number_attempts),
            color = AppTheme.colors.primary,
            style = AppTheme.typography.h5,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {
            items(4) { item ->

                if(stats.isNotEmpty()) {
                    OneRow(
                        number = item + 4,
                        progress = stats[item].numberAttempts,
                        isNumberAttempts = true
                    )
                }
            }
        }
    }
}