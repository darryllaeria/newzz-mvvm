package com.example.newzz.base.utils

import android.animation.Animator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.LinearInterpolator

object AnimateUtils {
    fun expand(view: View, height: Int, duration: Long = 400L) {
        animate(view, 0, height, duration)
    }

    fun collapse(view: View, duration: Long = 400L) {
        animate(view, view.height, 0, duration)
    }

    private fun animate(view: View, initValue: Int, targetValue: Int, duration: Long) {
        val valueAnimator = ValueAnimator.ofInt(initValue, targetValue)
        valueAnimator.addUpdateListener {
            view.layoutParams.height = it.animatedValue as Int
            view.requestLayout()
        }
        valueAnimator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                if (initValue > targetValue) {
                    view.visibility = View.GONE
                    view.alpha = 0f
                } else {
                    view.alpha = 1f
                }
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
                if (initValue < targetValue) {
                    view.alpha = 0f
                    view.visibility = View.VISIBLE
                }
            }
        })
        valueAnimator.duration = duration
        valueAnimator.interpolator = LinearInterpolator()
        valueAnimator.start()
    }
}