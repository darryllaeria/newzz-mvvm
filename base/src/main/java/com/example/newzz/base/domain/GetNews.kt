package com.example.newzz.base.domain

import com.example.newzz.base.base_component.BaseUseCase
import com.example.newzz.base.data.model.NewsArticlesModel
import com.example.newzz.base.repository.news.INewsRepository

class GetNews(
    private val newsRepo: INewsRepository
): BaseUseCase<Any, List<NewsArticlesModel>>() {
    override suspend fun execute(param: Any, callback: (List<NewsArticlesModel>) -> Unit) {
        TODO("Not yet implemented")
    }
}