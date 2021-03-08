package com.example.newzz.base.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.text.InputFilter
import android.widget.EditText
import androidx.core.app.ActivityCompat
import java.util.*

object Utils {

    // MARK: - Public Constant
    private val TAG: String = Utils::class.java.simpleName

    // MARK: - Public Functions
    /**
     *  Get image URI
     */
    fun getImageUri(context: Context, image: Bitmap): Uri? {
        val path: String = MediaStore.Images.Media.insertImage(context.contentResolver, image, "app_img", null)
        return Uri.parse(path)
    }

    /**
     *  Get images from Gallery
     */
    fun getGalleryImages(context: Activity): ArrayList<String> {
        val galleryImageUrls = ArrayList<String>()
        val columns = arrayOf(
            MediaStore.Images.Media.DATA,
            MediaStore.Images.Media._ID
        )
        val orderBy = MediaStore.Images.Media.DATE_ADDED

        // Get all data in Cursor by sorting in DESC order
        val imageCursor = context.managedQuery(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            columns,
            null,
            null,
            "$orderBy DESC"
        )

        for (i in 0 until imageCursor.count) {
            imageCursor.moveToPosition(i)
            val dataColumnIndex = imageCursor.getColumnIndex(MediaStore.Images.Media.DATA)
            galleryImageUrls.add(imageCursor.getString(dataColumnIndex))
        }

        return galleryImageUrls
    }

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