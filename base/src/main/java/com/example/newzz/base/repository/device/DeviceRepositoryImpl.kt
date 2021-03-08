package com.example.newzz.base.repository.device

import android.content.Context
import android.os.Build
import com.example.newzz.base.Constants
import com.example.newzz.base.data.model.DeleteDeviceRequest
import com.example.newzz.base.data.model.RegisterDeviceRequest
import com.example.newzz.base.data.remote.DeviceService
import com.example.newzz.base.extension.applyLocale
import com.example.newzz.base.extension.getCountryCode
import com.example.newzz.base.extension.getDeviceID
import com.example.newzz.base.manager.PrefsManager
import retrofit2.Response

class DeviceRepositoryImpl(
    private val context: Context,
    private val prefMan: PrefsManager,
    private val deviceService: DeviceService
): IDeviceRepository {

    private val DEVICE_TYPE = "android"
    override fun getDeviceID(): String = context.getDeviceID()

    /**
     * Check registration_id param
     */
    override suspend fun registerDevice(): Response<Any> {
        val request = RegisterDeviceRequest(context.getDeviceID(),
            prefMan.getString(Constants.KEY_AUTH_KEY, ""),
            Build.MODEL,
            DEVICE_TYPE)
        return deviceService.registerDevice(request)
    }

    override suspend fun deregisterDevice(): Response<Any> {
        val request = DeleteDeviceRequest(context.getDeviceID())
        return deviceService.deleteDevice(request)
    }

    override fun getCountryCode(): String = context.getCountryCode()

    override fun getLanguageConfig(): String {
        return prefMan.getString(Constants.Language.KEY_SETTINGS_LANGUAGE, Constants.Language.LANG_CODE_DEFAULT)
    }

    override fun setLanguageCode(languageCode: String) {
        prefMan.putString(Constants.Language.KEY_SETTINGS_LANGUAGE, languageCode)
        context.applyLocale()
    }

    override fun getSoundConfig(): String {
        return prefMan.getString(Constants.Notification.KEY_SETTINGS_SOUND, Constants.Notification.DEFAULT_SOUND)
    }

    override fun setSoundConfig(sound: String) {
    }

}
