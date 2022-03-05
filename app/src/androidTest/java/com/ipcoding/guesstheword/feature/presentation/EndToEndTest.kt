package com.ipcoding.guesstheword.feature.presentation
import androidx.activity.compose.BackHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
import kotlinx.coroutines.delay
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

    @Inject lateinit var preferences: Preferences
    @Inject lateinit var letterRepository: LetterRepository
    @Inject lateinit var gameRepository: GameRepository

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

    @Test
    fun game_test() {

        composeRule.onNodeWithText(chooseGameString).performClick()
        composeRule.onNodeWithText(Constants.TYPES_OF_GAMES[1]).performClick()
        val guessingWord = preferences.loadRandomWord()
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
        composeRule.onNodeWithContentDescription(enterIcon).performClick()
        runBlocking {
            delay(5000L)
        }

        composeRule.onNodeWithText("100%").assertDoesNotExist()

        composeRule.mainClock.advanceTimeBy(5000L)
    }
}
