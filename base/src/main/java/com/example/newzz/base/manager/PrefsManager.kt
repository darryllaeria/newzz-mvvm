package com.example.newzz.base.manager

import android.content.Context
import android.content.SharedPreferences

class PrefsManager(private val context: Context,
                   private val sharePrefs: SharedPreferences = context.getSharedPreferences(
                       PREFS_NAME, Context.MODE_PRIVATE)) {

    // MARK: - Companion Object
    companion object {
        private const val PREFS_NAME = "prefs_mgr"
        private var instance: PrefsManager? = null

        // MARK: - Public Constants
        const val KEY_AUTH_MODE = "auth_mode"
        const val KEY_CACHE_ASSETS_DATA = "cache_assets_data"
        const val KEY_CACHE_ASSETEXCHANGES_DATA = "cache_assetexchanges_data"
        const val KEY_CACHE_EXCHANGES_DATA = "cache_exchanges_data"
        const val KEY_IS_LOGGED_IN = "is_login"
        const val KEY_REG_EMAIL = "email"
        const val KEY_REG_FIRST_NAME = "first_name"
        const val KEY_REG_LAST_NAME = "last_name"
        const val KEY_REG_NUMBER = "number"
        const val KEY_REG_PWD = "password"
        const val KEY_REG_USR_NAME = "usr_name"
        const val KEY_SHOULD_SHOW_DOOBLE_BACKGROUND = "should_show_doodle_background"
        const val SIGNIN_MODE = "signin"
        const val SIGNUP_MODE = "signup"

        // MARK: - Public Function
        fun getInstance(context: Context): PrefsManager {
            if (instance == null)
                instance = PrefsManager(context)
            return instance!!
        }
    }

    // MARK: - Public Functions
    fun clear() {
        sharePrefs.edit().clear().apply()
    }

    fun deleteKey(key: String) {
        sharePrefs.edit().remove(key).apply()
    }

    fun getBool(key: String, defValue: Boolean): Boolean {
        return sharePrefs.getBoolean(key, defValue)
    }

    fun getFloat(key: String, defValue: Float): Float {
        return sharePrefs.getFloat(key, defValue)
    }

    fun getInt(key: String, defValue: Int): Int {
        return sharePrefs.getInt(key, defValue)
    }

    fun getLong(key: String, defValue: Long): Long {
        return sharePrefs.getLong(key, defValue)
    }

    fun getString(key: String, defValue: String): String {
        return sharePrefs.getString(key, defValue) ?: ""
    }

    fun putBool(key: String, value: Boolean) {
        sharePrefs.edit().putBoolean(key, value).apply()
    }

    fun putFloat(key: String, value: Float) {
        sharePrefs.edit().putFloat(key, value).commit()
    }

    fun putInt(key: String, value: Int) {
        sharePrefs.edit().putInt(key, value).apply()
    }

    fun putLong(key: String, value: Long) {
        sharePrefs.edit().putLong(key, value).apply()
    }

    fun putString(key: String, value: String) {
        sharePrefs.edit().putString(key, value).apply()
    }
}