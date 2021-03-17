package com.example.newzz.base.data.model

import com.squareup.moshi.Json

data class NewsArticleSource(
    @Json(name = NewsArticleSourceKey.id) var id: Int = 0,
    @Json(name = NewsArticleSourceKey.name) var name: String? = ""
)

object NewsArticleSourceKey  {
    const val id = "id"
    const val name = "name"
}