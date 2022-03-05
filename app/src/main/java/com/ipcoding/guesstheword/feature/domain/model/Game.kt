package com.ipcoding.guesstheword.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games_table")
data class Game(
    val typeGameNumber: Int,
    val guessingWord: String,
    val isVictory: Boolean,
    val numberAttempts: Int,
    @PrimaryKey var id: Int? = null
)
