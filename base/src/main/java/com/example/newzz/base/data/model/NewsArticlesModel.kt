package com.example.newzz.base.data.model

import com.squareup.moshi.Json

data class NewsArticlesModel(
    @Json(name = NewsArticlesKey.source) var source: NewsArticleSource?,
    @Json(name = NewsArticlesKey.author) var author: String? = "",
    @Json(name = NewsArticlesKey.title) var title: String? = "",
    @Json(name = NewsArticlesKey.description) var description: String? = "",
    @Json(name = NewsArticlesKey.url) var url: String? = "",
    @Json(name = NewsArticlesKey.urlToImage) var urlToImage: String? = "",
    @Json(name = NewsArticlesKey.publishedAt) var publishedAt: String? = "",
    @Json(name = NewsArticlesKey.content) var content: String? = ""
)

object NewsArticlesKey {
    const val source = "source"
    const val author = "author"
    const val title = "title"
    const val description = "description"
    const val url = "url"
    const val urlToImage = "urlToImage"
    const val publishedAt = "publishedAt"
    const val content = "content"
}