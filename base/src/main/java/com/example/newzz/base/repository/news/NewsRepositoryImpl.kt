package com.example.newzz.base.repository.news

import com.example.newzz.base.BuildConfig
import com.example.newzz.base.data.model.NewsItemModel
import com.example.newzz.base.data.remote.NewsService
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsService: NewsService
): INewsRepository {

    /**
     *  @Detail Get news items
     */
    override suspend fun loadNews(q: String?, from: String?, sortBy: String?): Response<NewsItemModel> {
        return newsService.getNewsItems(
            q,
            from,
            sortBy,
            BuildConfig.NEWS_API_KEY
        )
    }
}