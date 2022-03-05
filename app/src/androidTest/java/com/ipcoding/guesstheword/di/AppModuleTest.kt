package com.ipcoding.guesstheword.di

import android.app.Application
import androidx.room.Room
import com.ipcoding.guesstheword.core.data.DefaultPreferencesFake
import com.ipcoding.guesstheword.core.domain.preferences.Preferences
import com.ipcoding.guesstheword.feature.data.data_source.AppDatabase
import com.ipcoding.guesstheword.feature.data.repository.FakeGameRepository
import com.ipcoding.guesstheword.feature.data.repository.FakeLetterRepository
import com.ipcoding.guesstheword.feature.domain.repository.GameRepository
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import com.ipcoding.guesstheword.feature.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleTest {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.inMemoryDatabaseBuilder(
            app,
            AppDatabase::class.java
        ).build()
    }

    @Provides
    @Singleton
    fun provideLetterRepository(): LetterRepository {
        return FakeLetterRepository()
    }

    @Provides
    @Singleton
    fun provideGameRepository(): GameRepository {
        return FakeGameRepository()
    }

    @Provides
    @Singleton
    fun providePreferences(): Preferences {
        return DefaultPreferencesFake()
    }

    @Provides
    @Singleton
    fun provideUseCases(
        letterRepository: LetterRepository,
        gameRepository: GameRepository,
        preferences: Preferences
    ): AllUseCases {
        return AllUseCases(
            createDatabase = CreateDatabase(letterRepository),
            saveLetter = SaveLetter(letterRepository),
            getLetters = GetLetters(letterRepository),
            positionCurrentLetter = PositionCurrentLetter(letterRepository),
            deleteCurrentLetter = DeleteCurrentLetter(letterRepository),
            checkIfWordIsCorrect = CheckIfWordIsCorrect(letterRepository),
            checkAllLettersEntered = CheckAllLettersEntered(letterRepository),
            getKeyboardLetters = GetKeyboardLetters(letterRepository),
            checkWordInDictionary = CheckWordInDictionary(letterRepository),
            saveRandomWord = SaveRandomWord(preferences),
            insertGame = InsertGame(gameRepository),
            getStats = GetStats(gameRepository)
        )
    }
}