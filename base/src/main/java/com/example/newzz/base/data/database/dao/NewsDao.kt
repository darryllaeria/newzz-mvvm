package com.example.newzz.base.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.newzz.base.data.model.NewsArticlesModel

@Dao
interface NewsDao {

    @Query("SELECT * FROM news_articles")
    fun getAllNews(): LiveData<List<NewsArticlesModel>>

    @Insert
    fun insertNews(newsArticles: List<NewsArticlesModel>)

    @Delete
    fun deleteNews(newsId: NewsArticlesModel)
}