package com.messieyawo.gigglemusicpiano.fragments.stream.utils

import android.content.Context
import android.content.SharedPreferences




class PreferenceHelper(context: Context) {

    private val INTRO = "intro"
    private val NAME = "name"
    private val EMAIL = "email"
    private var app_prefs: SharedPreferences? = null
    private var context: Context? = null

    init {
        app_prefs = context.getSharedPreferences(
            "shared",
            Context.MODE_PRIVATE
        )
        this.context = context
    }


    fun putIsLogin(loginorout: Boolean) {
        val edit = app_prefs!!.edit()
        edit.putBoolean(INTRO, loginorout)
        edit.apply()
    }

    fun getIsLogin(): Boolean {
        return app_prefs!!.getBoolean(INTRO, false)
    }

    fun putName(loginorout: String?) {
        val edit = app_prefs!!.edit()
        edit.putString(NAME, loginorout)
        edit.apply()
    }

    fun getName(): String? {
        return app_prefs!!.getString(NAME, "")
    }

    fun putEmail(loginorout: String?) {
        val edit = app_prefs!!.edit()
        edit.putString(EMAIL, loginorout)
        edit.apply()
    }

    fun getEmail(): String? {
        return app_prefs!!.getString(EMAIL, "")
    }
}