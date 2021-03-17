package com.example.newzz.base.utils

import android.content.Context
import android.content.pm.PackageManager
import android.text.InputFilter
import android.widget.EditText
import androidx.core.app.ActivityCompat

object Utils {

    // MARK: - Public Constant
    private val TAG: String = Utils::class.java.simpleName

    // MARK: - Public Functions
    fun hasPermissions(context: Context, vararg permissions: String): Boolean = permissions.all {
        ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }

    /**
     *  Set max input length to EditText
     */
    fun setEditTextInputFilter(editText: EditText, maxLength: Int): EditText {
        editText.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
        return editText
    }

    /**
     *  Split by line, then ensure each line can fit into Log's maximum 4000 length.
     */
    fun splitLog(tag: String, message: String?) {
        val MAX_LOG_LENGTH = 4000
        var i = 0
        val length = message?.length
        while (i < length!!) {
            var newline = message.indexOf('\n', i)
            newline = if (newline != -1) newline else length
            do {
                val end = Math.min(newline, i + MAX_LOG_LENGTH)
                i = end
            } while (i < newline)
            i++
        }
    }
}