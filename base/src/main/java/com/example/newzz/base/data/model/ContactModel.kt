package com.example.newzz.base.data.model

import com.squareup.moshi.Json

// MARK: - Object
object ContactJsonKey {
    const val contact_list = "contact_list"
    const val device_id = "device_id"
    const val local_name = "local_name"
    const val phone_number = "phone_number"
}

// MARK: - Model Data Class
data class ContactModel(
    @Json(name = ContactJsonKey.phone_number) var phone_number: String? = "",
    @Json(name = ContactJsonKey.local_name) var local_name: String? = ""
)

// MARK: - Request Data Class
data class ContactsRequest(@Json(name = ContactJsonKey.contact_list) val contactList: List<ContactModel>,
                           @Json(name = ContactJsonKey.device_id) val deviceId: String)