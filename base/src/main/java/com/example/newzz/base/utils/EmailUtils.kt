package com.example.newzz.base.utils

import android.app.Activity
import androidx.core.app.ShareCompat
import com.example.newzz.base.BuildConfig

object EmailUtils {
    fun sendEmail(activity: Activity, subject: String, title: String) {
        ShareCompat.IntentBuilder.from(activity)
            .setType("message/rfc822")
            .addEmailTo(BuildConfig.APP_MAIL)
            .setSubject(subject)
            .setChooserTitle(title)
            .startChooser()
    }
}