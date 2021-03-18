package com.example.newzz.base.repository

import com.example.newzz.base.repository.news.INewsRepository
import com.example.newzz.base.repository.news.NewsRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<INewsRepository> { NewsRepositoryImpl(get(), get()) }
}