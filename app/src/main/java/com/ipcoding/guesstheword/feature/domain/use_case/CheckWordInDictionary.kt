package com.ipcoding.guesstheword.feature.domain.use_case

import com.ipcoding.guesstheword.core.util.all_words.five_letters.AWordsFiveLetters.A_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.BWordsFiveLetters.B_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.CWordsFiveLetters.C_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.DWordsFiveLetters.D_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.EWordsFiveLetters.E_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.FWordsFiveLetters.F_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.GWordsFiveLetters.G_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.HWordsFiveLetters.H_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.IWordsFiveLetters.I_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.JWordsFiveLetters.J_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.KWordsFiveLetters.K_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.LWordsFiveLetters.L_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.MWordsFiveLetters.M_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.NWordsFiveLetters.N_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.OWordsFiveLetters.O_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.OtherWordsFiveLetters.OTHER_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.PWordsFiveLetters.P_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.RWordsFiveLetters.R_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.SWordsFiveLetters.S_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.TWordsFiveLetters.T_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.UWordsFiveLetters.U_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.VWordsFiveLetters.V_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.five_letters.ZWordsFiveLetters.Z_WORDS_FIVE_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.AWordsFourLetters.A_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.BWordsFourLetters.B_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.CWordsFourLetters.C_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.DWordsFourLetters.D_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.EWordsFourLetters.E_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.FWordsFourLetters.F_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.GWordsFourLetters.G_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.HWordsFourLetters.H_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.IWordsFourLetters.I_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.JWordsFourLetters.J_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.KWordsFourLetters.K_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.LWordsFourLetters.L_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.MWordsFourLetters.M_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.NWordsFourLetters.N_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.OWordsFourLetters.O_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.OtherWordsFourLetters.OTHER_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.PWordsFourLetters.P_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.RWordsFourLetters.R_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.SWordsFourLetters.S_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.TWordsFourLetters.T_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.UWordsFourLetters.U_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.VWordsFourLetters.V_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.four_letters.ZWordsFourLetters.Z_WORDS_FOUR_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.AWordsSixLetters.A_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.BWordsSixLetters.B_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.CWordsSixLetters.C_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.DWordsSixLetters.D_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.EWordsSixLetters.E_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.FWordsSixLetters.F_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.GWordsSixLetters.G_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.HWordsSixLetters.H_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.IWordsSixLetters.I_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.JWordsSixLetters.J_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.KWordsSixLetters.K_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.LWordsSixLetters.L_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.MWordsSixLetters.M_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.NWordsSixLetters.N_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.OWordsSixLetters.O_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.OtherWordsSixLetters.OTHER_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.PWordsSixLetters.P_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.RWordsSixLetters.R_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.SWordsSixLetters.S_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.TWordsSixLetters.T_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.UWordsSixLetters.U_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.VWordsSixLetters.V_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.core.util.all_words.six_letters.ZWordsSixLetters.Z_WORDS_SIX_LETTERS
import com.ipcoding.guesstheword.feature.domain.model.Letter

class CheckWordInDictionary {

   operator fun invoke(row: Int, letters: List<Letter>, number:  Int): Boolean {

       var currentWord = ""

       for(column in 0 until number) {
           currentWord += letters[row * number + column].text
       }

       currentWord = currentWord.lowercase()

       return when(number) {
           4 -> fourWords(currentWord)
           5 -> fiveWords(currentWord)
           6 -> sixWords(currentWord)
           7 -> true
           else -> false
       }
   }

    private fun sixWords(currentWord: String): Boolean {
        return when(currentWord[0]) {
            'a' -> A_WORDS_SIX_LETTERS.contains(currentWord)
            'b' -> B_WORDS_SIX_LETTERS.contains(currentWord)
            'c' -> C_WORDS_SIX_LETTERS.contains(currentWord)
            'd' -> D_WORDS_SIX_LETTERS.contains(currentWord)
            'e' -> E_WORDS_SIX_LETTERS.contains(currentWord)
            'f' -> F_WORDS_SIX_LETTERS.contains(currentWord)
            'g' -> G_WORDS_SIX_LETTERS.contains(currentWord)
            'h' -> H_WORDS_SIX_LETTERS.contains(currentWord)
            'i' -> I_WORDS_SIX_LETTERS.contains(currentWord)
            'j' -> J_WORDS_SIX_LETTERS.contains(currentWord)
            'k' -> K_WORDS_SIX_LETTERS.contains(currentWord)
            'l' -> L_WORDS_SIX_LETTERS.contains(currentWord)
            'm' -> M_WORDS_SIX_LETTERS.contains(currentWord)
            'n' -> N_WORDS_SIX_LETTERS.contains(currentWord)
            'o' -> O_WORDS_SIX_LETTERS.contains(currentWord)
            'p' -> P_WORDS_SIX_LETTERS.contains(currentWord)
            'r' -> R_WORDS_SIX_LETTERS.contains(currentWord)
            's' -> S_WORDS_SIX_LETTERS.contains(currentWord)
            't' -> T_WORDS_SIX_LETTERS.contains(currentWord)
            'u' -> U_WORDS_SIX_LETTERS.contains(currentWord)
            'v' -> V_WORDS_SIX_LETTERS.contains(currentWord)
            'z' -> Z_WORDS_SIX_LETTERS.contains(currentWord)
            'š', 'č', 'ć', 'ž', 'đ' -> OTHER_WORDS_SIX_LETTERS.contains(currentWord)
            else -> false
        }
    }

    private fun fiveWords(currentWord: String): Boolean {
        return when(currentWord[0]) {
            'a' -> A_WORDS_FIVE_LETTERS.contains(currentWord)
            'b' -> B_WORDS_FIVE_LETTERS.contains(currentWord)
            'c' -> C_WORDS_FIVE_LETTERS.contains(currentWord)
            'd' -> D_WORDS_FIVE_LETTERS.contains(currentWord)
            'e' -> E_WORDS_FIVE_LETTERS.contains(currentWord)
            'f' -> F_WORDS_FIVE_LETTERS.contains(currentWord)
            'g' -> G_WORDS_FIVE_LETTERS.contains(currentWord)
            'h' -> H_WORDS_FIVE_LETTERS.contains(currentWord)
            'i' -> I_WORDS_FIVE_LETTERS.contains(currentWord)
            'j' -> J_WORDS_FIVE_LETTERS.contains(currentWord)
            'k' -> K_WORDS_FIVE_LETTERS.contains(currentWord)
            'l' -> L_WORDS_FIVE_LETTERS.contains(currentWord)
            'm' -> M_WORDS_FIVE_LETTERS.contains(currentWord)
            'n' -> N_WORDS_FIVE_LETTERS.contains(currentWord)
            'o' -> O_WORDS_FIVE_LETTERS.contains(currentWord)
            'p' -> P_WORDS_FIVE_LETTERS.contains(currentWord)
            'r' -> R_WORDS_FIVE_LETTERS.contains(currentWord)
            's' -> S_WORDS_FIVE_LETTERS.contains(currentWord)
            't' -> T_WORDS_FIVE_LETTERS.contains(currentWord)
            'u' -> U_WORDS_FIVE_LETTERS.contains(currentWord)
            'v' -> V_WORDS_FIVE_LETTERS.contains(currentWord)
            'z' -> Z_WORDS_FIVE_LETTERS.contains(currentWord)
            'š', 'č', 'ć', 'ž', 'đ' -> OTHER_WORDS_FIVE_LETTERS.contains(currentWord)
            else -> false
        }
    }

    private fun fourWords(currentWord: String): Boolean {
        return when(currentWord[0]) {
            'a' -> A_WORDS_FOUR_LETTERS.contains(currentWord)
            'b' -> B_WORDS_FOUR_LETTERS.contains(currentWord)
            'c' -> C_WORDS_FOUR_LETTERS.contains(currentWord)
            'd' -> D_WORDS_FOUR_LETTERS.contains(currentWord)
            'e' -> E_WORDS_FOUR_LETTERS.contains(currentWord)
            'f' -> F_WORDS_FOUR_LETTERS.contains(currentWord)
            'g' -> G_WORDS_FOUR_LETTERS.contains(currentWord)
            'h' -> H_WORDS_FOUR_LETTERS.contains(currentWord)
            'i' -> I_WORDS_FOUR_LETTERS.contains(currentWord)
            'j' -> J_WORDS_FOUR_LETTERS.contains(currentWord)
            'k' -> K_WORDS_FOUR_LETTERS.contains(currentWord)
            'l' -> L_WORDS_FOUR_LETTERS.contains(currentWord)
            'm' -> M_WORDS_FOUR_LETTERS.contains(currentWord)
            'n' -> N_WORDS_FOUR_LETTERS.contains(currentWord)
            'o' -> O_WORDS_FOUR_LETTERS.contains(currentWord)
            'p' -> P_WORDS_FOUR_LETTERS.contains(currentWord)
            'r' -> R_WORDS_FOUR_LETTERS.contains(currentWord)
            's' -> S_WORDS_FOUR_LETTERS.contains(currentWord)
            't' -> T_WORDS_FOUR_LETTERS.contains(currentWord)
            'u' -> U_WORDS_FOUR_LETTERS.contains(currentWord)
            'v' -> V_WORDS_FOUR_LETTERS.contains(currentWord)
            'z' -> Z_WORDS_FOUR_LETTERS.contains(currentWord)
            'š', 'č', 'ć', 'ž', 'đ' -> OTHER_WORDS_FOUR_LETTERS.contains(currentWord)
            else -> false
        }
    }
}