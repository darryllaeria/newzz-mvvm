package com.example.newzz.base.data.model

import android.text.TextUtils
import androidx.room.*
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi

@Entity(tableName = "news_articles")
data class NewsArticlesModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @Json(name = NewsArticlesKey.source)
    @ColumnInfo(name = NewsArticlesKey.source)
    @TypeConverters(NewsSourceConverter::class) var source: NewsArticleSource? = null,
    @ColumnInfo(name = NewsArticlesKey.author) @Json(name = NewsArticlesKey.author) var author: String? = "",
    @ColumnInfo(name = NewsArticlesKey.title)  @Json(name = NewsArticlesKey.title) var title: String? = "",
    @ColumnInfo(name = NewsArticlesKey.description) @Json(name = NewsArticlesKey.description) var description: String? = "",
    @ColumnInfo(name = NewsArticlesKey.url) @Json(name = NewsArticlesKey.url) var url: String? = "",
    @ColumnInfo(name = NewsArticlesKey.urlToImage) @Json(name = NewsArticlesKey.urlToImage) var urlToImage: String? = "",
    @ColumnInfo(name = NewsArticlesKey.publishedAt) @Json(name = NewsArticlesKey.publishedAt) var publishedAt: String? = "",
    @ColumnInfo(name = NewsArticlesKey.content) @Json(name = NewsArticlesKey.content) var content: String? = ""
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

class NewsSourceConverter {
    private val moshi = Moshi.Builder().build()

    @TypeConverter
    fun fromJson(string: String): NewsArticleSource? {
        if (TextUtils.isEmpty(string))
            return null
        val jsonAdapter = moshi.adapter(NewsArticleSource::class.java)
        return jsonAdapter.fromJson(string)
    }

    @TypeConverter
    fun toJson(newsSource: NewsArticleSource): String {
        val jsonAdapter = moshi.adapter(NewsArticleSource::class.java)
        return jsonAdapter.toJson(newsSource)
    }
}