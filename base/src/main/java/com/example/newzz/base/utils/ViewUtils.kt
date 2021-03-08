package com.example.newzz.base.utils

import android.view.View
import com.example.newzz.base.extension.hideView
import com.example.newzz.base.extension.showView

object ViewUtils {
    fun showViews(vararg views: View) {
        views.forEach {
            it.showView()
        }
    }

    fun hideViews(vararg views: View) {
        views.forEach {
            it.hideView()
        }
    }
}