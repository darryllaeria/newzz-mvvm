package com.example.newzz.base.data.model

import com.squareup.moshi.Json

// MARK: - Model Data Classes
data class MessageMediaData(
    @Json(name = MessageItemJsonKey.id) var id: String = "",
    @Json(name = MessageItemJsonKey.url) var url: String = ""
)

data class MessageMediaItemModel(
    @Json(name = MessageItemJsonKey.data) var data: MessageMediaData = MessageMediaData(),
    @Json(name = MessageItemJsonKey.message_id) var message_id: String = "",
    @Json(name = MessageItemJsonKey.sent_ts) var sent_ts: Double = 0.0,
    @Transient var room_id: String = ""
)

// MARK: - Response Data Classes
data class MessageMediaResponse(
    @Json(name = MessageItemJsonKey.items) var items: MutableList<MessageMediaItemModel>? = mutableListOf(),
    @Json(name = MessageItemJsonKey.room_id) @Transient var roomId: String = "",
    @Json(name = MessageItemJsonKey.pagination) @Transient var pagination: MessageItemPagination = MessageItemPagination(),
    @Json(name = MessageItemJsonKey.type) var type: String = ""
)
