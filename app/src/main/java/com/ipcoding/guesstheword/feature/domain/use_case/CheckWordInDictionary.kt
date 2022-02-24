package com.ipcoding.guesstheword.feature.domain.use_case

import android.util.Log
import com.ipcoding.guesstheword.core.util.all_words.AWords.A_WORDS
import com.ipcoding.guesstheword.core.util.all_words.BWords.B_WORDS
import com.ipcoding.guesstheword.core.util.all_words.CWords.C_WORDS
import com.ipcoding.guesstheword.core.util.all_words.DWords.D_WORDS
import com.ipcoding.guesstheword.core.util.all_words.EWords.E_WORDS
import com.ipcoding.guesstheword.core.util.all_words.FWords.F_WORDS
import com.ipcoding.guesstheword.core.util.all_words.GWords.G_WORDS
import com.ipcoding.guesstheword.core.util.all_words.HWords.H_WORDS
import com.ipcoding.guesstheword.core.util.all_words.IWords.I_WORDS
import com.ipcoding.guesstheword.core.util.all_words.JWords.J_WORDS
import com.ipcoding.guesstheword.core.util.all_words.KWords.K_WORDS
import com.ipcoding.guesstheword.core.util.all_words.LWords.L_WORDS
import com.ipcoding.guesstheword.core.util.all_words.MWords.M_WORDS
import com.ipcoding.guesstheword.core.util.all_words.NWords.N_WORDS
import com.ipcoding.guesstheword.core.util.all_words.OWords.O_WORDS
import com.ipcoding.guesstheword.core.util.all_words.OtherWords.OTHER_WORDS
import com.ipcoding.guesstheword.core.util.all_words.PWords.P_WORDS
import com.ipcoding.guesstheword.core.util.all_words.RWords.R_WORDS
import com.ipcoding.guesstheword.core.util.all_words.SWords.S_WORDS
import com.ipcoding.guesstheword.core.util.all_words.TWords.T_WORDS
import com.ipcoding.guesstheword.core.util.all_words.UWords.U_WORDS
import com.ipcoding.guesstheword.core.util.all_words.VWords.V_WORDS
import com.ipcoding.guesstheword.core.util.all_words.ZWords.Z_WORDS
import com.ipcoding.guesstheword.feature.domain.model.Letter

class CheckWordInDictionary {

   operator fun invoke(row: Int, letters: List<Letter>): Boolean {

       var currentWord = ""

       for(column in 0..4) {
           currentWord += letters[row * 5 + column].text
       }

       currentWord = currentWord.lowercase()

       return when(currentWord[0]) {
           'a' -> A_WORDS.contains(currentWord)
           'b' -> B_WORDS.contains(currentWord)
           'c' -> C_WORDS.contains(currentWord)
           'd' -> D_WORDS.contains(currentWord)
           'e' -> E_WORDS.contains(currentWord)
           'f' -> F_WORDS.contains(currentWord)
           'g' -> G_WORDS.contains(currentWord)
           'h' -> H_WORDS.contains(currentWord)
           'i' -> I_WORDS.contains(currentWord)
           'j' -> J_WORDS.contains(currentWord)
           'k' -> K_WORDS.contains(currentWord)
           'l' -> L_WORDS.contains(currentWord)
           'm' -> M_WORDS.contains(currentWord)
           'n' -> N_WORDS.contains(currentWord)
           'o' -> O_WORDS.contains(currentWord)
           'p' -> P_WORDS.contains(currentWord)
           'r' -> R_WORDS.contains(currentWord)
           's' -> S_WORDS.contains(currentWord)
           't' -> T_WORDS.contains(currentWord)
           'u' -> U_WORDS.contains(currentWord)
           'v' -> V_WORDS.contains(currentWord)
           'z' -> Z_WORDS.contains(currentWord)
           'š', 'č', 'ć', 'ž', 'đ' -> OTHER_WORDS.contains(currentWord)
           else -> false
       }
   }
}