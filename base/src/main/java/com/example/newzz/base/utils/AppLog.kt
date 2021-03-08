package com.example.newzz.base.utils

import android.util.Log
import com.example.newzz.base.BuildConfig

object AppLog {

    private const val APP_LOG_TAG: String = BuildConfig.APP_NAME

    fun d(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.d(tag, msg)
        }
    }

    fun d(msg: String) {
        if (BuildConfig.DEBUG) {
            d(APP_LOG_TAG, msg)
        }
    }

    fun e(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.e(tag, msg)
        }
    }

    fun e(msg: String) {
        if (BuildConfig.DEBUG) {
            d(APP_LOG_TAG, msg)
        }
    }

    fun w(tag: String, msg: String) {
        if (BuildConfig.DEBUG) {
            Log.w(tag, msg)
        }
    }

    fun w(msg: String) {
        if (BuildConfig.DEBUG) {
            d(APP_LOG_TAG, msg)
        }
    }

    fun printStackTrace(ex: Exception) {
        if (BuildConfig.DEBUG) {
            ex.printStackTrace()
        }
    }

    fun printStackTrace(ex: Throwable) {
        if (BuildConfig.DEBUG) {
            ex.stackTrace
        }
    }
}