package com.example.newzz

import com.example.newzz.home.homeModule
import com.example.newzz.base.getDataModule
import org.koin.core.module.Module

fun getModule(): List<Module> {
    return mutableListOf<Module>().apply {
        addAll(getDataModule())
        add(homeModule)
    }
}