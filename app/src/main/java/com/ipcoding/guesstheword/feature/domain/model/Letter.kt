package com.ipcoding.guesstheword.feature.domain.model

import androidx.compose.ui.graphics.toArgb
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ipcoding.guesstheword.ui.theme.Colors

@Entity(tableName = "letters_table")
data class Letter(
    var text: String = "",
    val row: Int,
    val column: Int,
    var color: Int = Colors.Blue.toArgb(),
    @PrimaryKey val id: Int? = null
)
