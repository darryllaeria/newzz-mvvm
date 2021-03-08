package com.example.newzz.base.extension

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.net.ConnectivityManager
import android.os.Build
import android.provider.ContactsContract
import android.provider.Settings
import android.telephony.TelephonyManager
import android.util.DisplayMetrics
import androidx.core.app.ActivityCompat
import com.example.newzz.base.Constants
import com.example.newzz.base.data.model.ContactModel
import com.example.newzz.base.manager.PrefsManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.math.roundToInt

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

fun Context.copyToClipboard(text: String) {
    val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    clipboard.primaryClip = ClipData.newPlainText(Constants.CLIP_BOARD, text)
}

fun Context.createConfiguration(): Configuration {
    val language = PrefsManager.getInstance(this)
        .getString(Constants.Language.KEY_SETTINGS_LANGUAGE, Constants.Language.LANG_CODE_DEFAULT)

    val locale = Locale(language)
    Locale.setDefault(locale)
    return Configuration().apply {
        setLocale(locale)
    }
}

fun Context.dpToPx(dp: Float): Int {
    val density = resources.displayMetrics.densityDpi.toFloat()
    return (dp * density / DisplayMetrics.DENSITY_DEFAULT).roundToInt()
}

fun Context.pxToDp(px: Float): Float {
    val density = resources.displayMetrics.densityDpi.toFloat()
    return px / (density / DisplayMetrics.DENSITY_DEFAULT)
}

fun Context.getAllLocalContacts(): MutableList<ContactModel> {
    val contentResolver = contentResolver
    val contactCursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, "${ContactsContract.Contacts.DISPLAY_NAME} ASC")
    val localContacts = mutableListOf<ContactModel>()
    if (contactCursor != null && contactCursor.count > 0) {
        while (contactCursor.moveToNext()) {
            val contact = ContactModel()
            contact.local_name = contactCursor.getString(
                contactCursor.getColumnIndex(
                    ContactsContract.Contacts.DISPLAY_NAME
                )
            ) ?: ""

            localContacts.add(contact)

            if (contactCursor.getInt(contactCursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                val id = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts._ID)) ?: ""
                val phoneNumberCursor = contentResolver.query(
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                    null,
                    ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                    arrayOf(id),
                    null
                )
                while (phoneNumberCursor?.moveToNext()!!) {
                    val phoneNo = phoneNumberCursor.getString(
                        phoneNumberCursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        )
                    ) ?: ""
                    // Remove all characters that are not number
                    contact.phone_number = phoneNo.trim()//phoneNo.replace("[^0-9]+".toRegex(), "")
                }
                phoneNumberCursor.close()
            }
        }
    }
    contactCursor?.close()
    return localContacts
}

fun Context.getCountryCode(): String {
    val telephony = getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telephony.networkCountryIso
}

fun Context.getDeviceID(): String {
    return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
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

fun Context.isGranted(permission: String): Boolean {
    return ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED
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