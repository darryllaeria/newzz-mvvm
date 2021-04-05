package com.example.newzz.home.ui.home

import androidx.lifecycle.MutableLiveData
import com.example.newzz.base.base_component.BaseViewModel
import com.example.newzz.base.data.model.NewsArticlesModel
import com.example.newzz.base.utils.AppLog
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

//    private val appDatabase = AppDatabase.getInstance(getApplication(), uiScope)
    var allNews = MutableLiveData<List<NewsArticlesModel>>()

    companion object {
        private val TAG: String = HomeViewModel::class.java.simpleName
    }

    fun loadNewsArticles() {
        uiScope.launch {
            try {
//                allNews = appDatabase.newsDao().getAllNews() as MutableLiveData<List<NewsArticlesModel>>
            } catch (e: Exception) {
                AppLog.d(TAG, "Can't access AppDatabase")
            }
        }
    }
}