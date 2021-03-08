package com.example.newzz.base

import com.example.newzz.base.data.database.localModule
import com.example.newzz.base.data.encryption.KeyStoreWrapper
import com.example.newzz.base.data.remote.remoteModule
import com.example.newzz.base.domain.domainModule
import com.example.newzz.base.manager.managerModule
import com.example.newzz.base.repository.repositoryModule
import org.koin.core.module.Module
import org.koin.dsl.module

val utilModule = module {
    single { KeyStoreWrapper(get()) }
}

fun getDataModule(): List<Module> {
    return mutableListOf(utilModule).apply {
        add(domainModule)
        add(localModule)
        add(managerModule)
        add(remoteModule)
        add(repositoryModule)
    }
}