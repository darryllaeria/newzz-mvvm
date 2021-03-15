package com.example.newzz.home.ui.home

import com.example.newzz.home.R
import com.example.newzz.base.base_component.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment: BaseFragment() {

    override var layoutId = R.layout.fragment_home
    private val viewModel: HomeViewModel by viewModel()

    override fun initLogic() {
        super.initLogic()
    }

    override fun unsubscribeObservers() {
        super.unsubscribeObservers()
    }
}