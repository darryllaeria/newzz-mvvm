package com.example.newzz.base.repository.news

import com.example.newzz.base.data.database.dao.NewsDao
import com.example.newzz.base.data.model.NewsArticlesModel
import com.example.newzz.base.data.remote.NewsService
import com.example.newzz.base.utils.AppLog
import kotlinx.coroutines.runBlocking
import org.json.JSONArray
import org.json.JSONObject

class NewsRepositoryImpl(
    private val newsService: NewsService,
    private val newsDao: NewsDao
): INewsRepository {
    // MARK: - Companion Object
    companion object {
        private val TAG: String = NewsRepositoryImpl::class.java.simpleName
    }

    override suspend fun loadNewsAPI(q: String?, from: String?, sortBy: String?): Boolean {
        val jsonResponse = JSONObject(newsService.getNewsItems(q, from, sortBy).string().trim())
        val jsonArticles = jsonResponse.getJSONArray("articles")
        return storeNewsJson(jsonArticles)
    }

    override fun loadNewsLocal(): List<NewsArticlesModel> {
        TODO("Not yet implemented")
    }

    override fun storeNewsAPI(news: List<NewsArticlesModel>) {
        TODO("Not yet implemented")
    }

    override fun storeNewsJson(jsonArray: JSONArray): Boolean {
        return try {
            runBlocking {
                TODO("Not yet implemented")
            }
        } catch (e: Exception) {
            AppLog.d(TAG, "Store articles failed with exception: $e")
            false
        }
    }

    override fun saveJsonDatas(jsonArray: JSONArray): Boolean {
        return true
    }
}