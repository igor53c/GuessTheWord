package com.ipcoding.guesstheword.di

import android.app.Application
import androidx.room.Room
import com.ipcoding.guesstheword.core.data.DefaultPreferencesFake
import com.ipcoding.guesstheword.core.domain.preferences.Preferences
import com.ipcoding.guesstheword.feature.data.data_source.AppDatabase
import com.ipcoding.guesstheword.feature.data.repository.GameRepositoryImpl
import com.ipcoding.guesstheword.feature.data.repository.LetterRepositoryImpl
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
    fun provideLetterRepository(db: AppDatabase): LetterRepository {
        return LetterRepositoryImpl(db.letterDao)
    }

    @Provides
    @Singleton
    fun provideGameRepository(db: AppDatabase): GameRepository {
        return GameRepositoryImpl(db.gameDao)
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
            positionCurrentLetter = PositionCurrentLetter(),
            deleteCurrentLetter = DeleteCurrentLetter(letterRepository),
            checkIfWordIsCorrect = CheckIfWordIsCorrect(letterRepository),
            checkAllLettersEntered = CheckAllLettersEntered(letterRepository),
            getKeyboardLetters = GetKeyboardLetters(letterRepository),
            checkWordInDictionary = CheckWordInDictionary(),
            saveRandomWord = SaveRandomWord(preferences),
            insertGame = InsertGame(gameRepository),
            getStats = GetStats(gameRepository)
        )
    }
}