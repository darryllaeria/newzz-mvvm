package com.example.newzz.base

object Constants {

    const val DB_NAME = "realm"
    const val DEFAULT_MESSAGE_ID = -1
    const val KEY_VERSION_REALM_SCHEMA = "realm_schema_version"
    const val KEY_SECRET_DB = "secret_db"
    const val CLIP_BOARD = "clip_board"

    // App
    object App {
        const val DIR_NAME = "${BuildConfig.APP_NAME}_images"
    }

    // Language code
    object Language {
        const val KEY_SETTINGS_LANGUAGE = "key_language"
        const val LANG_CODE_DEFAULT = "en"
        const val LANG_CODE_VIETNAMESE = "vi"
        const val LANG_CODE_ENGLISH = "en"
        const val DEFAULT_COUNTRY_CODE = "en"
    }

    // Notification & Sound
    object Notification {
        const val KEY_SETTINGS_SOUND = "key_sound"
        const val DEFAULT_SOUND = "none"
    }

    const val PASSWORD_LENGTH = 6
    const val DELAY_TIME = 2_500L
    const val KEY_IS_LOGGED_IN = "is_login"
    const val KEY_AUTH_KEY = "auth_key"
}