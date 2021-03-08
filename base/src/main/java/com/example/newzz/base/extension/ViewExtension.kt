package com.example.newzz.base.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.res.Resources
import android.view.View

// MARK: - View
fun View.hideView() {
    visibility = View.GONE
}

/**
 * Hide a view using fade animation with a specified duration of how long the animation should take
 * By default, the default value for animateDuration is 0. Calling this method without providing
 * a duration will cause the view to disappear without any animation.
 * @param animateDuration The length of ensuing property animations, in milliseconds. The value
 * cannot be negative.
 */
fun View.hideWithAnimation(animateDuration: Long = 0, completion: (() -> Unit)? = null) {
    apply {
        // Animate the loading view to 0% opacity. After the animation ends,
        // set its visibility to GONE as an optimization step (it won't
        // participate in layout passes, etc.)
        animate()
            .alpha(0f)
            .setDuration(animateDuration)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    visibility = View.GONE
                    completion?.invoke()
                }
            })
    }
}

fun View.showView() {
    visibility = View.VISIBLE
}

/**
 * Show a view using fade animation with a specified duration of how long the animation should take
 * By default, the default value for animateDuration is 0. Calling this method without providing
 * a duration will cause the view to appear without any animation.
 * @param animateDuration The length of ensuing property animations, in milliseconds. The value
 * cannot be negative.
 */
fun View.showWithAnimation(animateDuration: Long = 0, completion: (() -> Unit)? = null) {
    apply {
        // Set the content view to 0% opacity but visible, so that it is visible
        // (but fully transparent) during the animation.
        alpha = 0f
        visibility = View.VISIBLE

        // Animate the content view to 100% opacity, and clear any animation
        // listener set on the view.
        animate()
            .alpha(1f)
            .setDuration(animateDuration)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    completion?.invoke()
                }
            })
    }
}

fun View.invisibleView() {
    visibility = View.INVISIBLE
}

// MARK: - Public Functions
fun getScreenWidth(): Int {
    return Resources.getSystem().displayMetrics.widthPixels
}

fun getScreenHeight(): Int {
    return Resources.getSystem().displayMetrics.heightPixels
}

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

fun invisibleViews(vararg views: View) {
    views.forEach {
        it.visibility = View.INVISIBLE
    }
}