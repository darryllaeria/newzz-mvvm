package com.example.newzz.base.data.remote

import com.example.newzz.base.data.model.NewsItemModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    /**
     *  Get news items
     */
    @GET("/everything")
    suspend fun getNewsItems(@Query("q") query: String
    ): Response<NewsItemModel>
}