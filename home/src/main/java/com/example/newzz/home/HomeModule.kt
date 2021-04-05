package com.example.newzz.home

import com.example.newzz.home.ui.home.HomeViewModel
import com.example.newzz.home.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    viewModel { HomeViewModel() }
    viewModel { SplashViewModel() }
}