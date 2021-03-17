package com.example.newzz.base.data.model

import com.squareup.moshi.Json

data class NewsItemModel(
    @Json(name = NewsItemKey.status) var status: String? = "",
    @Json(name = NewsItemKey.totalResults) var totalResults: Int = 0,
    @Json(name = NewsItemKey.articles) var articles: MutableList<NewsArticlesModel>? = mutableListOf()
)

object NewsItemKey {
    const val status = "status"
    const val totalResults = "totalResults"
    const val articles = "articles"
}