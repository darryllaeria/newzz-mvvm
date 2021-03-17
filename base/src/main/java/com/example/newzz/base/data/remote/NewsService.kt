package com.example.newzz.base.data.remote

import com.example.newzz.base.BuildConfig
import com.example.newzz.base.data.model.NewsItemModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    /**
     *  @Detail Get news items
     */
    @GET("/everything")
    suspend fun getNewsItems(@Query("q") q: String? = "",
                             @Query("from") from: String? = "",
                             @Query("sortBy") sortBy: String? = "",
                             @Query("apiKey") query: String? = BuildConfig.NEWS_API_KEY
    ): Response<NewsItemModel>
}