package com.example.newzz.base.repository.news

interface INewsRepository {

    /**
     *  @Detail Get news items
     */
    suspend fun loadNews(q: String?, from: String?, sortBy: String?): Boolean
}