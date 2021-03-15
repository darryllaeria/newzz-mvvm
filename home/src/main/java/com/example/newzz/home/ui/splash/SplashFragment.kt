package com.example.newzz.home.ui.splash

import android.os.Handler
import android.os.Looper
import com.example.newzz.home.R
import com.example.newzz.base.base_component.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment: BaseFragment(R.layout.fragment_splash) {

    private val viewModel: SplashViewModel by viewModel()

    override fun initLogic() {
        super.initLogic()
        Handler(Looper.getMainLooper()).postDelayed({
            navigateTo(R.id.action_splash_to_home)
        }, 2000)
    }
}