package com.example.newzz.base.repository.news

import com.example.newzz.base.data.model.NewsItemModel
import retrofit2.Response

interface INewsRepository {

    /**
     *  @Detail Get news items
     */
    suspend fun loadNews(q: String?, from: String?, sortBy: String?): Response<NewsItemModel>
}