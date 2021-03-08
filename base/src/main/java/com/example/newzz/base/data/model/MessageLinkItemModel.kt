package com.example.newzz.base.data.model

import com.squareup.moshi.Json

// MARK: - Model Data Classes
data class MessageLinkItemModel(
    @Json(name = MessageItemJsonKey.link) var link: String = "",
    @Json(name = MessageItemJsonKey.message_id) var message_id: String = "",
    @Json(name = MessageItemJsonKey.sent_ts) var sent_ts: Double = 0.0,
    @Transient var main_image_url: String? = null,
    @Transient var room_id: String = "",
    @Transient var title: String? = null
)

// MARK: - Response Data Classes
data class MessageLinkResponse(
    @Json(name = MessageItemJsonKey.items) var items: MutableList<MessageLinkItemModel>? = mutableListOf(),
    @Json(name = MessageItemJsonKey.room_id) @Transient var roomId: String = "",
    @Json(name = MessageItemJsonKey.pagination) @Transient var pagination: MessageItemPagination = MessageItemPagination(),
    @Json(name = MessageItemJsonKey.type) var type: String = ""
)