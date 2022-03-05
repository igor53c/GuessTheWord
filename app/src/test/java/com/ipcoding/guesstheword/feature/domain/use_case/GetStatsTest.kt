package com.ipcoding.guesstheword.feature.domain.use_case

import com.google.common.truth.Truth.assertThat
import com.ipcoding.guesstheword.feature.data.repository.GameRepositoryFake
import com.ipcoding.guesstheword.feature.domain.model.Game
import com.ipcoding.guesstheword.feature.domain.util.Stats
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetStatsTest {

    private lateinit var gameRepositoryFake: GameRepositoryFake
    private lateinit var getStats: GetStats

    @Before
    fun setUp() {

        gameRepositoryFake = GameRepositoryFake()
        getStats = GetStats(gameRepositoryFake)
    }

    @Test
    fun `check if the game statistics of 4 letters are correct`() {

        var result: Stats

        runBlocking {
            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 4,
                    guessingWord = "",
                    isVictory = true,
                    numberAttempts = 1
                )
            )

            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 4,
                    guessingWord = "",
                    isVictory = false,
                    numberAttempts = 4
                )
            )

            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 4,
                    guessingWord = "",
                    isVictory = true,
                    numberAttempts = 4
                )
            )

            result = getStats()[0]
        }

        assertThat(result.guessingSuccess).isEqualTo(2f / 3)
        assertThat(result.numberAttempts).isEqualTo(5f / 2)
    }

    @Test
    fun `check if the game statistics of 5 letters are correct`() {

        var result: Stats

        runBlocking {
            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 5,
                    guessingWord = "",
                    isVictory = true,
                    numberAttempts = 3
                )
            )

            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 5,
                    guessingWord = "",
                    isVictory = false,
                    numberAttempts = 4
                )
            )

            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 5,
                    guessingWord = "",
                    isVictory = true,
                    numberAttempts = 5
                )
            )

            result = getStats()[1]
        }

        assertThat(result.guessingSuccess).isEqualTo(2f / 3)
        assertThat(result.numberAttempts).isEqualTo(4)
    }

    @Test
    fun `check if the game statistics of 6 letters are correct`() {

        var result: Stats

        runBlocking {
            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 6,
                    guessingWord = "",
                    isVictory = true,
                    numberAttempts = 3
                )
            )

            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 6,
                    guessingWord = "",
                    isVictory = false,
                    numberAttempts = 4
                )
            )

            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 6,
                    guessingWord = "",
                    isVictory = true,
                    numberAttempts = 5
                )
            )

            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 6,
                    guessingWord = "",
                    isVictory = true,
                    numberAttempts = 6
                )
            )

            result = getStats()[2]
        }

        assertThat(result.guessingSuccess).isEqualTo(3f / 4)
        assertThat(result.numberAttempts).isEqualTo(14f / 3)
    }

    @Test
    fun `check if the game statistics of 7 letters are correct`() {

        var result: Stats

        runBlocking {
            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 7,
                    guessingWord = "",
                    isVictory = false,
                    numberAttempts = 3
                )
            )

            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 7,
                    guessingWord = "",
                    isVictory = false,
                    numberAttempts = 4
                )
            )

            gameRepositoryFake.insertGame(
                Game(
                    typeGameNumber = 7,
                    guessingWord = "",
                    isVictory = true,
                    numberAttempts = 7
                )
            )

            result = getStats()[3]
        }

        assertThat(result.guessingSuccess).isEqualTo(1f / 3)
        assertThat(result.numberAttempts).isEqualTo(7f)
    }
}