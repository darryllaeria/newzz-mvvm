package com.example.newzz.home.ui.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.newzz.base.base_component.BaseViewModel
import com.example.newzz.base.data.database.AppDatabase
import com.example.newzz.base.data.model.NewsArticlesModel
import com.example.newzz.base.repository.news.INewsRepository
import com.example.newzz.base.utils.AppLog
import kotlinx.coroutines.launch

class HomeViewModel(
    mApplication: Application,
    private val newsRepo: INewsRepository
): BaseViewModel(mApplication) {

    private val appDatabase = AppDatabase.getInstance(getApplication(), uiScope)
    var allNews = MutableLiveData<List<NewsArticlesModel>>()

    companion object {
        private val TAG: String = HomeViewModel::class.java.simpleName
    }

    fun getAllNewsArticles() {
        uiScope.launch {
            try {
                allNews = appDatabase.newsDao().getAllNews() as MutableLiveData<List<NewsArticlesModel>>
            } catch (e: Exception) {
                AppLog.d(TAG, "Can't access AppDatabase")
            }
        }
    }
}