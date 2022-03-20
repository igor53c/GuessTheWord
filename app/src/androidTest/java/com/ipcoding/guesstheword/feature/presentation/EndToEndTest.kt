package com.ipcoding.guesstheword.feature.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.material.Surface
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.test.espresso.Espresso
import com.ipcoding.guesstheword.R
import com.ipcoding.guesstheword.core.domain.preferences.Preferences
import com.ipcoding.guesstheword.core.util.Constants
import com.ipcoding.guesstheword.di.AppModule
import com.ipcoding.guesstheword.feature.domain.repository.GameRepository
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import com.ipcoding.guesstheword.feature.presentation.game.GameScreen
import com.ipcoding.guesstheword.feature.presentation.info.InfoScreen
import com.ipcoding.guesstheword.feature.presentation.start.StartScreen
import com.ipcoding.guesstheword.feature.presentation.statistics.StatisticsScreen
import com.ipcoding.guesstheword.feature.presentation.util.Screen
import com.ipcoding.guesstheword.ui.theme.AppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(AppModule::class)
class EndToEndTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()

    @Inject
    lateinit var preferences: Preferences

    @Inject
    lateinit var letterRepository: LetterRepository

    @Inject
    lateinit var gameRepository: GameRepository

    private lateinit var navController: NavHostController
    private lateinit var chooseGameString: String
    private lateinit var enterIcon: String

    @Before
    fun setUp() {

        hiltRule.inject()
        composeRule.setContent {
            AppTheme {
                navController = rememberNavController()
                chooseGameString = stringResource(id = R.string.choose_game)
                enterIcon = stringResource(id = R.string.enter_icon)
                Surface(
                    color = AppTheme.colors.background
                ) {
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
                                onChangeThemeClick = {}
                            )
                            BackHandler(true) {}
                        }
                        composable(route = Screen.StatisticsScreen.route) {
                            StatisticsScreen()
                            BackHandler(true) {
                                navController.navigate(Screen.StartScreen.route)
                            }
                        }
                        composable(route = Screen.InfoScreen.route) {
                            InfoScreen()
                            BackHandler(true) {
                                navController.navigate(Screen.StartScreen.route)
                            }
                        }
                    }
                }
            }
        }
    }

    @Test
    fun fourGame_5x5_is100percent() {

        playGame(numberAttempts = 1, gameNumber = 1)

        Espresso.pressBack()

        playGame(numberAttempts = 2, gameNumber = 2)

        Espresso.pressBack()

        playGame(numberAttempts = 3, gameNumber = 3)

        Espresso.pressBack()

        playGame(numberAttempts = 5, gameNumber = 4)
    }

    private fun playGame(numberAttempts: Int, gameNumber: Int) {
        composeRule.onNodeWithText(chooseGameString).performClick()
        composeRule.onNodeWithText(Constants.TYPES_OF_GAMES[1]).performClick()
        val guessingWord = preferences.loadRandomWord()

        for (i in 1 until numberAttempts) {

            composeRule.onNodeWithText("M").performClick()

            composeRule.onNodeWithText("E").performClick()

            composeRule.onNodeWithText("T").performClick()

            composeRule.onNodeWithText("R").performClick()

            composeRule.onNodeWithText("A").performClick()

            composeRule.waitUntil(10000L) {
                runBlocking { letterRepository.getLetters()[(i - 1) * 5 + 4].text != "" }
            }

            composeRule.onNodeWithContentDescription(enterIcon).performClick()

            var number = 0
            composeRule.waitUntil(10000L) {
                runBlocking {
                    number++
                    number == 200
                }
            }
        }

        guessingWord?.get(0)?.let {
            composeRule.onNodeWithText(it.uppercase()).performClick()
        }

        guessingWord?.get(1)?.let {
            composeRule.onNodeWithText(it.uppercase()).performClick()
        }

        guessingWord?.get(2)?.let {
            composeRule.onNodeWithText(it.uppercase()).performClick()
        }

        guessingWord?.get(3)?.let {
            composeRule.onNodeWithText(it.uppercase()).performClick()
        }

        guessingWord?.get(4)?.let {
            composeRule.onNodeWithText(it.uppercase()).performClick()
        }

        composeRule.waitUntil(10000L) {
            runBlocking { letterRepository.getLetters()[(numberAttempts - 1) * 5 + 4].text != "" }
        }

        composeRule.onNodeWithContentDescription(enterIcon).performClick()

        composeRule.waitUntil(10000L) {
            runBlocking { gameRepository.getGames(5).size == gameNumber }
        }

        var number = 0

        composeRule.waitUntil(10000L) {
            number++
            number == 50
        }

        composeRule.onNodeWithText("100%").assertExists()
    }
}
