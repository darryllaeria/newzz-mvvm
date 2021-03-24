package com.example.newzz.base.repository.news

import com.example.newzz.base.data.model.NewsArticlesModel
import org.json.JSONArray

interface INewsRepository {

    // Get news items from API
    suspend fun loadNewsAPI(q: String?, from: String?, sortBy: String?): Boolean

    // Get news items from local Room
    fun loadNewsLocal(): List<NewsArticlesModel>

    // Store news items from API to Room
    fun storeNewsAPI(news: List<NewsArticlesModel>)

    // Save news items as JSONArray
    fun storeNewsJson(jsonArray: JSONArray): Boolean

    // Save JSONArray datas
    fun saveJsonDatas(jsonArray: JSONArray): Boolean
}