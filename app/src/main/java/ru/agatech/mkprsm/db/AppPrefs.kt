package ru.agatech.mkprsm.db

import android.content.ClipData
import android.content.Context
import android.content.SharedPreferences

object AppPrefs {
    private const val NAME = "PartnerPrefs"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var prefs: SharedPreferences
    lateinit var login: String
    lateinit var data: String
    private val FIRST_RUN = Pair("firstrun", false)

    fun init(context: Context) {
        prefs = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var fr: Boolean
    get() = prefs.getBoolean(FIRST_RUN.first, FIRST_RUN.second)
    set(value) = prefs.edit() {
        it.putBoolean(FIRST_RUN.first, value)
    }
}