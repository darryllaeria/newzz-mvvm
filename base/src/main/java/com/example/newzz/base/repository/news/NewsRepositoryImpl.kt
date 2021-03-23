package com.example.newzz.base.repository.news

import androidx.annotation.WorkerThread
import com.example.newzz.base.data.database.dao.NewsDao
import com.example.newzz.base.data.remote.NewsService


class NewsRepositoryImpl(
    private val newsService: NewsService,
    private val newsDao: NewsDao
): INewsRepository {

    // MARK: - Companion Object
    companion object {
        private val TAG: String = NewsRepositoryImpl::class.java.simpleName
    }

    @WorkerThread
    override suspend fun loadNews(q: String?, from: String?, sortBy: String?): Boolean {
        TODO("Not yet implemented")
    }
}