package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.core.util.all_words.five_letters.*
import com.ipcoding.guesstheword.core.util.all_words.four_letters.*
import com.ipcoding.guesstheword.core.util.all_words.seven_words.*
import com.ipcoding.guesstheword.core.util.all_words.six_letters.*
import com.ipcoding.guesstheword.feature.domain.repository.LetterRepository

class CheckWordInDictionary(
    private val letterRepository: LetterRepository
) {

    suspend operator fun invoke(row: Int, number: Int): Boolean {

        val letters = letterRepository.getLetters()
        var currentWord = ""

        for (column in 0 until number) {
            currentWord += letters[row * number + column].text
        }

        currentWord = currentWord.lowercase()

        return when (number) {
            4 -> fourWords(currentWord)
            5 -> fiveWords(currentWord)
            6 -> sixWords(currentWord)
            7 -> sevenWords(currentWord)
            else -> false
        }
    }

    private fun sevenWords(currentWord: String): Boolean {
        return when (currentWord[0]) {
            'a' -> AWordsSevenLetters.A_WORDS_SEVEN_LETTERS.contains(currentWord)
            'b' -> BWordsSevenLetters.B_WORDS_SEVEN_LETTERS.contains(currentWord)
            'c' -> CWordsSevenLetters.C_WORDS_SEVEN_LETTERS.contains(currentWord)
            'd' -> DWordsSevenLetters.D_WORDS_SEVEN_LETTERS.contains(currentWord)
            'e' -> EWordsSevenLetters.E_WORDS_SEVEN_LETTERS.contains(currentWord)
            'f' -> FWordsSevenLetters.F_WORDS_SEVEN_LETTERS.contains(currentWord)
            'g' -> GWordsSevenLetters.G_WORDS_SEVEN_LETTERS.contains(currentWord)
            'h' -> HWordsSevenLetters.H_WORDS_SEVEN_LETTERS.contains(currentWord)
            'i' -> IWordsSevenLetters.I_WORDS_SEVEN_LETTERS.contains(currentWord)
            'j' -> JWordsSevenLetters.J_WORDS_SEVEN_LETTERS.contains(currentWord)
            'k' -> KWordsSevenLetters.K_WORDS_SEVEN_LETTERS.contains(currentWord)
            'l' -> LWordsSevenLetters.L_WORDS_SEVEN_LETTERS.contains(currentWord)
            'm' -> MWordsSevenLetters.M_WORDS_SEVEN_LETTERS.contains(currentWord)
            'n' -> NWordsSevenLetters.N_WORDS_SEVEN_LETTERS.contains(currentWord)
            'o' -> OWordsSevenLetters.O_WORDS_SEVEN_LETTERS.contains(currentWord)
            'p' -> PWordsSevenLetters.P_WORDS_SEVEN_LETTERS.contains(currentWord)
            'r' -> RWordsSevenLetters.R_WORDS_SEVEN_LETTERS.contains(currentWord)
            's' -> SWordsSevenLetters.S_WORDS_SEVEN_LETTERS.contains(currentWord)
            't' -> TWordsSevenLetters.T_WORDS_SEVEN_LETTERS.contains(currentWord)
            'u' -> UWordsSevenLetters.U_WORDS_SEVEN_LETTERS.contains(currentWord)
            'v' -> VWordsSevenLetters.V_WORDS_SEVEN_LETTERS.contains(currentWord)
            'z' -> ZWordsSevenLetters.Z_WORDS_SEVEN_LETTERS.contains(currentWord)
            'š', 'č', 'ć', 'ž', 'đ' -> OtherWordsSevenLetters.OTHER_WORDS_SEVEN_LETTERS.contains(
                currentWord
            )
            else -> false
        }
    }

    private fun sixWords(currentWord: String): Boolean {
        return when (currentWord[0]) {
            'a' -> AWordsSixLetters.A_WORDS_SIX_LETTERS.contains(currentWord)
            'b' -> BWordsSixLetters.B_WORDS_SIX_LETTERS.contains(currentWord)
            'c' -> CWordsSixLetters.C_WORDS_SIX_LETTERS.contains(currentWord)
            'd' -> DWordsSixLetters.D_WORDS_SIX_LETTERS.contains(currentWord)
            'e' -> EWordsSixLetters.E_WORDS_SIX_LETTERS.contains(currentWord)
            'f' -> FWordsSixLetters.F_WORDS_SIX_LETTERS.contains(currentWord)
            'g' -> GWordsSixLetters.G_WORDS_SIX_LETTERS.contains(currentWord)
            'h' -> HWordsSixLetters.H_WORDS_SIX_LETTERS.contains(currentWord)
            'i' -> IWordsSixLetters.I_WORDS_SIX_LETTERS.contains(currentWord)
            'j' -> JWordsSixLetters.J_WORDS_SIX_LETTERS.contains(currentWord)
            'k' -> KWordsSixLetters.K_WORDS_SIX_LETTERS.contains(currentWord)
            'l' -> LWordsSixLetters.L_WORDS_SIX_LETTERS.contains(currentWord)
            'm' -> MWordsSixLetters.M_WORDS_SIX_LETTERS.contains(currentWord)
            'n' -> NWordsSixLetters.N_WORDS_SIX_LETTERS.contains(currentWord)
            'o' -> OWordsSixLetters.O_WORDS_SIX_LETTERS.contains(currentWord)
            'p' -> PWordsSixLetters.P_WORDS_SIX_LETTERS.contains(currentWord)
            'r' -> RWordsSixLetters.R_WORDS_SIX_LETTERS.contains(currentWord)
            's' -> SWordsSixLetters.S_WORDS_SIX_LETTERS.contains(currentWord)
            't' -> TWordsSixLetters.T_WORDS_SIX_LETTERS.contains(currentWord)
            'u' -> UWordsSixLetters.U_WORDS_SIX_LETTERS.contains(currentWord)
            'v' -> VWordsSixLetters.V_WORDS_SIX_LETTERS.contains(currentWord)
            'z' -> ZWordsSixLetters.Z_WORDS_SIX_LETTERS.contains(currentWord)
            'š', 'č', 'ć', 'ž', 'đ' -> OtherWordsSixLetters.OTHER_WORDS_SIX_LETTERS.contains(
                currentWord
            )
            else -> false
        }
    }

    private fun fiveWords(currentWord: String): Boolean {
        return when (currentWord[0]) {
            'a' -> AWordsFiveLetters.A_WORDS_FIVE_LETTERS.contains(currentWord)
            'b' -> BWordsFiveLetters.B_WORDS_FIVE_LETTERS.contains(currentWord)
            'c' -> CWordsFiveLetters.C_WORDS_FIVE_LETTERS.contains(currentWord)
            'd' -> DWordsFiveLetters.D_WORDS_FIVE_LETTERS.contains(currentWord)
            'e' -> EWordsFiveLetters.E_WORDS_FIVE_LETTERS.contains(currentWord)
            'f' -> FWordsFiveLetters.F_WORDS_FIVE_LETTERS.contains(currentWord)
            'g' -> GWordsFiveLetters.G_WORDS_FIVE_LETTERS.contains(currentWord)
            'h' -> HWordsFiveLetters.H_WORDS_FIVE_LETTERS.contains(currentWord)
            'i' -> IWordsFiveLetters.I_WORDS_FIVE_LETTERS.contains(currentWord)
            'j' -> JWordsFiveLetters.J_WORDS_FIVE_LETTERS.contains(currentWord)
            'k' -> KWordsFiveLetters.K_WORDS_FIVE_LETTERS.contains(currentWord)
            'l' -> LWordsFiveLetters.L_WORDS_FIVE_LETTERS.contains(currentWord)
            'm' -> MWordsFiveLetters.M_WORDS_FIVE_LETTERS.contains(currentWord)
            'n' -> NWordsFiveLetters.N_WORDS_FIVE_LETTERS.contains(currentWord)
            'o' -> OWordsFiveLetters.O_WORDS_FIVE_LETTERS.contains(currentWord)
            'p' -> PWordsFiveLetters.P_WORDS_FIVE_LETTERS.contains(currentWord)
            'r' -> RWordsFiveLetters.R_WORDS_FIVE_LETTERS.contains(currentWord)
            's' -> SWordsFiveLetters.S_WORDS_FIVE_LETTERS.contains(currentWord)
            't' -> TWordsFiveLetters.T_WORDS_FIVE_LETTERS.contains(currentWord)
            'u' -> UWordsFiveLetters.U_WORDS_FIVE_LETTERS.contains(currentWord)
            'v' -> VWordsFiveLetters.V_WORDS_FIVE_LETTERS.contains(currentWord)
            'z' -> ZWordsFiveLetters.Z_WORDS_FIVE_LETTERS.contains(currentWord)
            'š', 'č', 'ć', 'ž', 'đ' -> OtherWordsFiveLetters.OTHER_WORDS_FIVE_LETTERS.contains(
                currentWord
            )
            else -> false
        }
    }

    private fun fourWords(currentWord: String): Boolean {
        return when (currentWord[0]) {
            'a' -> AWordsFourLetters.A_WORDS_FOUR_LETTERS.contains(currentWord)
            'b' -> BWordsFourLetters.B_WORDS_FOUR_LETTERS.contains(currentWord)
            'c' -> CWordsFourLetters.C_WORDS_FOUR_LETTERS.contains(currentWord)
            'd' -> DWordsFourLetters.D_WORDS_FOUR_LETTERS.contains(currentWord)
            'e' -> EWordsFourLetters.E_WORDS_FOUR_LETTERS.contains(currentWord)
            'f' -> FWordsFourLetters.F_WORDS_FOUR_LETTERS.contains(currentWord)
            'g' -> GWordsFourLetters.G_WORDS_FOUR_LETTERS.contains(currentWord)
            'h' -> HWordsFourLetters.H_WORDS_FOUR_LETTERS.contains(currentWord)
            'i' -> IWordsFourLetters.I_WORDS_FOUR_LETTERS.contains(currentWord)
            'j' -> JWordsFourLetters.J_WORDS_FOUR_LETTERS.contains(currentWord)
            'k' -> KWordsFourLetters.K_WORDS_FOUR_LETTERS.contains(currentWord)
            'l' -> LWordsFourLetters.L_WORDS_FOUR_LETTERS.contains(currentWord)
            'm' -> MWordsFourLetters.M_WORDS_FOUR_LETTERS.contains(currentWord)
            'n' -> NWordsFourLetters.N_WORDS_FOUR_LETTERS.contains(currentWord)
            'o' -> OWordsFourLetters.O_WORDS_FOUR_LETTERS.contains(currentWord)
            'p' -> PWordsFourLetters.P_WORDS_FOUR_LETTERS.contains(currentWord)
            'r' -> RWordsFourLetters.R_WORDS_FOUR_LETTERS.contains(currentWord)
            's' -> SWordsFourLetters.S_WORDS_FOUR_LETTERS.contains(currentWord)
            't' -> TWordsFourLetters.T_WORDS_FOUR_LETTERS.contains(currentWord)
            'u' -> UWordsFourLetters.U_WORDS_FOUR_LETTERS.contains(currentWord)
            'v' -> VWordsFourLetters.V_WORDS_FOUR_LETTERS.contains(currentWord)
            'z' -> ZWordsFourLetters.Z_WORDS_FOUR_LETTERS.contains(currentWord)
            'š', 'č', 'ć', 'ž', 'đ' -> OtherWordsFourLetters.OTHER_WORDS_FOUR_LETTERS.contains(
                currentWord
            )
            else -> false
        }
    }
}