package com.example.newzz.authentication.ui.splash

import androidx.lifecycle.MutableLiveData
import com.example.newzz.base.base_component.BaseViewModel

class SplashViewModel(): BaseViewModel() {

    // MARK: - Public Variable
    var isUserAuthorized = MutableLiveData<Boolean>()

    // MARK: - Public Function
    fun checkAuthorization() {
    }
}