package com.example.newzz.base.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.squareup.moshi.Json

@Entity(tableName = "news_source")
data class NewsArticleSource(
    @ColumnInfo(name = NewsArticleSourceKey.id) @Json(name = NewsArticleSourceKey.id) var id: Int = 0,
    @ColumnInfo(name = NewsArticleSourceKey.name) @Json(name = NewsArticleSourceKey.name) var name: String? = ""
)

object NewsArticleSourceKey  {
    const val id = "id"
    const val name = "name"
}