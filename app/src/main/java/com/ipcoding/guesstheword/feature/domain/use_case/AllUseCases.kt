package com.ipcoding.guesstheword.feature.domain.use_case

data class AllUseCases (
    val createDatabase: CreateDatabase,
    val saveLetter: SaveLetter,
    val getLetters: GetLetters,
    val positionCurrentLetter: PositionCurrentLetter,
    val deleteCurrentLetter: DeleteCurrentLetter,
    val checkIfWordIsCorrect: CheckIfWordIsCorrect
)