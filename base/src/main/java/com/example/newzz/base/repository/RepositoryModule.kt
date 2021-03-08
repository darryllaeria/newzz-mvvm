package com.example.newzz.base.repository

import com.example.newzz.base.repository.device.DeviceRepositoryImpl
import com.example.newzz.base.repository.device.IDeviceRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IDeviceRepository> { DeviceRepositoryImpl(get(), get(), get()) }
}