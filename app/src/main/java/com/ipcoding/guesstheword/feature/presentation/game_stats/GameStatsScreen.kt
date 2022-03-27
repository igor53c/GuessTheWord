package com.ipcoding.guesstheword.feature.presentation.game_stats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.core.util.Constants
import com.ipcoding.guesstheword.feature.presentation.game_stats.components.InfoText
import com.ipcoding.guesstheword.ui.theme.AppTheme

@Composable
fun GameStatsScreen(
    viewModel: GameStatsViewModel = hiltViewModel()
) {
    val gameNumber = viewModel.gameNumber.value
    val gameStats = viewModel.gameStats.value

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
            text = Constants.TYPES_OF_GAMES[gameNumber - 4],
            color = AppTheme.colors.primary,
            style = AppTheme.typography.h3,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        InfoText(
            explanation = stringResource(id = R.string.total_games_played),
            value = gameStats.totalGamesPlayed.toString(),
            padding = AppTheme.dimensions.spaceExtraMedium
        )

        InfoText(
            explanation = stringResource(id = R.string.number_of_wins),
            value = gameStats.numberOfWins.toString(),
            padding = AppTheme.dimensions.spaceExtraMedium
        )

        InfoText(
            explanation = stringResource(id = R.string.wins_from_attempts),
            value = "",
            padding = AppTheme.dimensions.spaceExtraMedium
        )

        LazyColumn(
            modifier = Modifier
                .weight(1f)
        ) {
            items(gameStats.winsFromAttempts.size) { item ->

                val number = item + 1

                InfoText(
                    explanation = "$number:    ",
                    value = gameStats.winsFromAttempts[item].toString()
                )
            }
        }
    }
}