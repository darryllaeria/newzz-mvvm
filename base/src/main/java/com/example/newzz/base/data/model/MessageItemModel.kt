package com.example.newzz.base.data.model

import com.squareup.moshi.Json

// MARK: - Object
object MessageItemJsonKey {
    const val data = "data"
    const val id = "id"
    const val items = "items"
    const val link = "link"
    const val message_id = "message_id"
    const val next_index = "next_index"
    const val num_record = "num_record"
    const val page_size = "page_size"
    const val pagination = "pagination"
    const val room_id = "room_id"
    const val sent_ts = "sent_ts"
    const val type = "type"
    const val url = "url"
}

// MARK: - Model Data Classes
data class MessageItemPagination(
    @Json(name = MessageItemJsonKey.next_index) var next_index: Int? = 0,
    @Json(name = MessageItemJsonKey.num_record) var num_record: Int? = 0,
    @Json(name = MessageItemJsonKey.page_size) var page_size: Int? = 0
)