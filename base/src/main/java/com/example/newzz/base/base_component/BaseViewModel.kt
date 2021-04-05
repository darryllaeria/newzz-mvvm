package com.example.newzz.base.base_component

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.newzz.base.Constants.DEFAULT_MESSAGE_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

sealed class UIState {
    object INIT: UIState()
    object DONE: UIState()
    data class LOADING(val messageId: Int = DEFAULT_MESSAGE_ID): UIState()
    data class FINISHED<T>(val data: T?, val messageId: Int = DEFAULT_MESSAGE_ID): UIState()
    data class FAILED(val messageId: Int = DEFAULT_MESSAGE_ID, val tempData: Any? = null): UIState()
}

open class BaseViewModel(mApplication: Application? = null): ViewModel() {
    private val job = Job()
    private val ioContext = Dispatchers.IO + job
    private val uiContext = Dispatchers.Main + job

    val ioScope = CoroutineScope(ioContext)
    val uiScope = CoroutineScope(uiContext)

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}