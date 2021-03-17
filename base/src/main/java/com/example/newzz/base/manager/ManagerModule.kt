package com.example.newzz.base.manager

import org.koin.dsl.module

val managerModule = module {
    single { PrefsManager(get()) }
}