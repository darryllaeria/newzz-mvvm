package com.example.newzz.base.repository.device

import retrofit2.Response

/**
 * @detail: Get all info of device
 */
interface IDeviceRepository {

    fun getDeviceID(): String

    suspend fun registerDevice(): Response<Any>

    suspend fun deregisterDevice(): Response<Any>

    fun getCountryCode(): String

    fun getLanguageConfig(): String

    fun setLanguageCode(languageCode: String)

    fun getSoundConfig(): String

    fun setSoundConfig(sound: String)
}