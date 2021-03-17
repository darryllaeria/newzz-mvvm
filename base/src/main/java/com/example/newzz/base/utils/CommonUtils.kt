package com.example.newzz.base.utils

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.view.View
import android.view.inputmethod.InputMethodManager

object CommonUtils {

    // MARK: - Public Constant
    private val TAG: String = CommonUtils::class.java.simpleName

    // MARK: - Public Functions
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