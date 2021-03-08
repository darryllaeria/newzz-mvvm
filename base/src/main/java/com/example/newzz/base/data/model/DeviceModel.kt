package com.example.newzz.base.data.model

import com.squareup.moshi.Json

// MARK: - Object
object DeviceJsonKey {
    const val device_id = "device_id"
    const val name = "name"
    const val registration_id = "registration_id"
    const val type = "type"
}

// MARK: - Request Data Classes
data class RegisterDeviceRequest(@Json(name = DeviceJsonKey.device_id) val deviceId: String,
                                 @Json(name = DeviceJsonKey.registration_id) val registrationId: String,
                                 @Json(name = DeviceJsonKey.name) val deviceName: String,
                                 @Json(name = DeviceJsonKey.type) val type: String)

data class DeleteDeviceRequest(@Json(name = DeviceJsonKey.device_id) val deviceId: String)
