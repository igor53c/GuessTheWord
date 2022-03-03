package com.ipcoding.guesstheword.feature.presentation.start

import androidx.activity.compose.BackHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.core.util.Constants.TYPES_OF_GAMES
import com.ipcoding.guesstheword.di.AppModule
import com.ipcoding.guesstheword.feature.presentation.MainActivity
import com.ipcoding.guesstheword.feature.presentation.game.GameScreen
import com.ipcoding.guesstheword.feature.presentation.statistics.StatisticsScreen
import com.ipcoding.guesstheword.feature.presentation.util.Screen
import com.ipcoding.guesstheword.ui.theme.AppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class StartScreenTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    private lateinit var navController: NavHostController
    private lateinit var chooseGameString: String
    private lateinit var changeModeIconString: String
    private lateinit var shareIconString: String
    private lateinit var rateAppIconString: String
    private lateinit var openStatsIconString: String
    private lateinit var infoIconString: String

    @Before
    fun setUp() {
        hiltRule.inject()
        composeRule.setContent {
            AppTheme {
                chooseGameString = stringResource(id = R.string.choose_game)
                changeModeIconString = stringResource(id = R.string.change_mode_icon)
                shareIconString = stringResource(id = R.string.share_icon)
                rateAppIconString = stringResource(id = R.string.rate_app_icon)
                openStatsIconString = stringResource(id = R.string.open_stats_icon)
                infoIconString = stringResource(id = R.string.info_icon)
                navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Screen.StartScreen.route
                ) {
                    composable(route = Screen.GameScreen.route) {
                        GameScreen(navController = navController)
                    }
                    composable(route = Screen.StartScreen.route) {
                        StartScreen(
                            navController = navController,
                            onChangeThemeClick = { }
                        )
                        BackHandler(true) {}
                    }
                    composable(route = Screen.StatisticsScreen.route) {
                        StatisticsScreen(navController = navController)
                        BackHandler(true) {
                            navController.navigate(Screen.StartScreen.route)
                        }
                    }
                }
            }
        }
    }

    @Test
    fun typesOfGames_areVisible() {
        composeRule.onNodeWithText(chooseGameString).performClick()
        composeRule.onNodeWithText(TYPES_OF_GAMES[0]).assertIsDisplayed()
        composeRule.onNodeWithText(TYPES_OF_GAMES[1]).assertIsDisplayed()
        composeRule.onNodeWithText(TYPES_OF_GAMES[2]).assertIsDisplayed()
        composeRule.onNodeWithText(TYPES_OF_GAMES[3]).assertIsDisplayed()
    }

    @Test
    fun icons_areVisible() {
        composeRule.onNodeWithContentDescription(changeModeIconString).assertIsDisplayed()
        composeRule.onNodeWithContentDescription(shareIconString).assertIsDisplayed()
        composeRule.onNodeWithContentDescription(rateAppIconString).assertIsDisplayed()
        composeRule.onNodeWithContentDescription(openStatsIconString).assertIsDisplayed()
        composeRule.onNodeWithContentDescription(infoIconString).assertIsDisplayed()
    }
}