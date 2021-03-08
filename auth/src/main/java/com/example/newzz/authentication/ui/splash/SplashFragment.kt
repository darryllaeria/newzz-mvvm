package com.example.newzz.authentication.ui.splash
import com.example.newzz.authentication.R
import com.example.newzz.base.base_component.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment: BaseFragment() {

    override var layoutId = R.layout.fragment_splash
    private val viewModel: SplashViewModel by viewModel()

    override fun initLogic() {
        super.initLogic()
    }

    override fun unsubscribeObservers() {
        super.unsubscribeObservers()
    }
}