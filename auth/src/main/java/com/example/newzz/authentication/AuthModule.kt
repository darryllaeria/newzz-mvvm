package com.example.newzz.authentication

import com.example.newzz.authentication.ui.splash.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val authModule = module {
    viewModel { SplashViewModel() }
}