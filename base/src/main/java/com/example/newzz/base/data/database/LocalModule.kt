package com.example.newzz.base.data.database

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import org.koin.dsl.module
import java.util.concurrent.Executors

val localModule = module {
    single { CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher()) }
}