package com.ipcoding.guesstheword.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.ipcoding.guesstheword.core.data.DefaultPreferences
import com.ipcoding.guesstheword.core.domain.preferences.Preferences
import com.ipcoding.guesstheword.feature.data.data_source.AppDatabase
import com.ipcoding.guesstheword.feature.data.repository.LetterRepositoryImpl
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository
import com.ipcoding.guesstheword.feature.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideLetterRepository(db: AppDatabase): LetterRepository {
        return LetterRepositoryImpl(db.letterDao)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideUseCases(
        letterRepository: LetterRepository
    ): AllUseCases {
        return AllUseCases(
            createDatabase = CreateDatabase(letterRepository),
            saveLetter = SaveLetter(letterRepository),
            getLetters = GetLetters(letterRepository),
            positionCurrentLetter = PositionCurrentLetter(),
            deleteCurrentLetter = DeleteCurrentLetter(letterRepository),
            checkIfWordIsCorrect = CheckIfWordIsCorrect(letterRepository)
        )
    }
}