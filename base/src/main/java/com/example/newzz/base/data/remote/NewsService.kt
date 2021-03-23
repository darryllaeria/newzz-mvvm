package com.example.newzz.base.data.remote

import com.example.newzz.base.BuildConfig
import okhttp3.ResponseBody
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
    ): ResponseBody
}