package com.example.newzz.base.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.os.Handler
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.newzz.base.Constants
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.lang.reflect.Type

object CommonUtils {

    // MARK: - Public Constant
    private val TAG: String = CommonUtils::class.java.simpleName

    // MARK: - Public Functions
    /**
     * @method convert bitmap to byte array to store in DB
     * @param bitmap bitmap of image
     * @return byte array of image
     */
    fun bitmapToByteArray(bitmap: Bitmap): ByteArray? {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream)
        return stream.toByteArray()
    }

    /**
     * @method convert byte array to bitmap
     * @param byteArray byte array of image
     * @return bitmap is image
     */
    fun byteArrayToBitmap(byteArray: ByteArray?): Bitmap? {
        byteArray?.let {
            return BitmapFactory.decodeByteArray(it, 0, it.size)
        }
        return null
    }

    /**
     * @method converts json to class/pojo
     * @param json to be converted
     * @param classOfT the pojo
     * @return Any the converted json class/pojo
     * */
    fun <T> getClassFromJson(json: String, classOfT: Class<T>): Any {
        val newJson = json.replace("\"extra_data\": \"\"", "\"extra_data\": {}")
        return try {
            Gson().fromJson(newJson, classOfT as Type)
        } catch (e: JsonSyntaxException) {
            AppLog.e(TAG, "Cannot get class from json with exception: $e")
            ""
        }
    }

    /**
     * @method converts json to class/pojo
     * @param json to be converted
     * @param classOfT the pojo
     * @return Any the converted json class/pojo
     * */
    fun <T> getClassFromJsonNew(json: String, classOfT: Class<T>): T {
        val newJson = json.replace("\"extra_data\": \"\"", "\"extra_data\": {}")
        return Gson().fromJson(newJson, classOfT as Type)
    }

    /**
     * @method create a new image file to save edited image
     * @return File file object that contains new file path
     */
    fun getNewFile(): File {
        val fileDir = File(
            Environment.getExternalStorageDirectory().toString()
                    + File.separator + Constants.App.DIR_NAME
        )
        val fileImage = File(
            Environment.getExternalStorageDirectory().toString()
                    + File.separator + Constants.App.DIR_NAME + File.separator + System.currentTimeMillis() + ".jpg"
        )
        try {
            if (fileDir.exists().not()) fileDir.mkdirs()
            if (fileImage.exists().not()) fileImage.createNewFile()
        } catch (e: IOException) {
            AppLog.d(TAG, "Can't get new file with exception: $e")
        }
        return fileImage
    }


    /**
     * @method To hide the soft key pad if open
     * @param context context of fragment
     */
    fun hideKeyboard(context: Context) {
        val activity = context as Activity
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(
            activity.currentFocus?.windowToken,
            InputMethodManager.HIDE_NOT_ALWAYS
        )
    }

    /**
     * @method to detect the message mentioning user
     * @param message the message string
     * @return is mentioning any user
     */
    fun isMentioning(message: String): Boolean {
        var isMentioning = false
        if (message.contains("@")) {
            val arr = message.split("@").last()
            if (arr.isNotEmpty() && arr.contains(" ").not()) {
                isMentioning = true
            }
        }
        return isMentioning
    }

    /**
     * @method open Browser of the mobile
     * @param context context of the current fragment
     * @param url string to be displayed at Browser
     */
    fun openBrowser(context: Context, url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        context.startActivity(i)
    }

    /**
     * @method open call dialler of the mobile
     * @param context context of the current fragment
     * @param phoneNumber string to be displayed at dialler
     */
    fun openDialler(context: Context, phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        context.startActivity(intent)
    }

    /**
     * @method To show the soft key pad
     * @param view view to be opened on behalf
     */
    fun showKeyboard(view: View, delay: Long = 200) {
        Handler().postDelayed({
            if (view.requestFocus()) {
                val activity = view.context as Activity
                val imm =
                    activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(
                    view,
                    InputMethodManager.SHOW_IMPLICIT
                )
            }
        }, delay)
    }
}