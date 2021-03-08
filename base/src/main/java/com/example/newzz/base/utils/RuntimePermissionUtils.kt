package com.example.newzz.base.utils

import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager.PERMISSION_GRANTED
import androidx.core.app.ActivityCompat
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

interface RuntimePermissionCallback {
    fun onGranted()
    fun onFailed()
}

object RuntimePermissionUtils {
    fun requestPermission(activity: Activity, permissions: List<String>, callback: RuntimePermissionCallback) {
        Dexter.withActivity(activity)
            .withPermissions(permissions)
            .withListener(object: MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    if (report!!.areAllPermissionsGranted()) {
                        callback.onGranted()
                    } else {
                        callback.onFailed()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    token?.continuePermissionRequest()
                }

            })
            .onSameThread()
            .check()

    }

    fun checkPermission(context: Context, permission: String): Boolean {
        return ActivityCompat.checkSelfPermission(context, permission) == PERMISSION_GRANTED
    }
}