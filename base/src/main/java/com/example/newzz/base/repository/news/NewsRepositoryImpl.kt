package com.example.newzz.base.repository.news

import com.example.newzz.base.BuildConfig
import com.example.newzz.base.data.database.dao.NewsDao
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

    override suspend fun loadNews(q: String?, from: String?, sortBy: String?): Boolean {
        TODO("Not yet implemented")
        // Dummy
    }

//    override fun saveNewsJsons(jsonArray: JSONArray): Boolean {
//        return try {
//            runBlocking {
//                val ids = newsDao.saveJSONDatas(jsonArray)
//                val dataSize = jsonArray.length()
//                dataSize != 0 && ids.size == dataSize
//            }
//        } catch (e: Exception) {
//            AppLog.d(TAG, "Store user failed with exception: $e")
//            false
//        }
//    }
//
//    /**
//     *  @Detail Get news items
//     */
//    override suspend fun loadNews(q: String?, from: String?, sortBy: String?): Boolean {
//        val jsonObject = JSONObject(newsService.getNewsItems(q, from, sortBy, BuildConfig.NEWS_API_KEY).string().trim())
//        val jsonArray = jsonObject.getJSONArray("articles")
//        return saveNewsJsons(jsonArray)
//    }
}