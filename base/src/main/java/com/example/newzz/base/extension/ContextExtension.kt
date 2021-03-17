package com.example.newzz.base.extension

import android.content.Context
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.os.Build
import com.example.newzz.base.Constants
import com.example.newzz.base.manager.PrefsManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.*

// MARK: - Context
fun Context?.applyLocale(): Context? {
    if (this != null) {
        val language = PrefsManager.getInstance(this)
            .getString(
                Constants.Language.KEY_SETTINGS_LANGUAGE,
                Constants.Language.LANG_CODE_DEFAULT
            )

        val locale = Locale(language)
        Locale.setDefault(locale)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            updateLocaleResource(this, locale)
        } else {
            updateLocaleResourceLegacy(this, locale)
        }
    }
    return this
}

fun Context.hasInternetConnection(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val info = cm.activeNetworkInfo
    return if (info != null && info.isConnected) {
        runBlocking {
            withContext(Dispatchers.Default) {
                try {
                    val process = Runtime.getRuntime().exec("ping -c 1 8.8.8.8")
                    process.waitFor() == 0
                } catch (e: Exception) {
                    false
                }
            }
        }
    } else {
        false
    }
}

// MARK: - Private Functions
private fun updateLocaleResourceLegacy(context: Context, locale: Locale): Context {
    val config = context.resources.configuration
    config.setLocale(locale)
    context.resources.updateConfiguration(config, context.resources.displayMetrics)
    return context
}

private fun updateLocaleResource(context: Context, locale: Locale): Context {
    val config = Configuration()
    config.setLocale(locale)
    return context.createConfigurationContext(config)
}