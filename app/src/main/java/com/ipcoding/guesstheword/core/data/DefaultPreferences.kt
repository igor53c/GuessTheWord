package com.ipcoding.guesstheword.core.data

import android.content.SharedPreferences
import com.ipcoding.guesstheword.core.domain.preferences.Preferences

class DefaultPreferences(
    private val sharedPreferences: SharedPreferences
) : Preferences {

}