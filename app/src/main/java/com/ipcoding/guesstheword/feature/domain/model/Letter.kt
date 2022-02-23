package com.ipcoding.guesstheword.feature.domain.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "letters_table")
data class Letter(
    val text: String = "",
    val row: Int,
    val column: Int,
    val color: Int = Color.Transparent.toArgb(),
    @PrimaryKey val id: Int? = null
)
