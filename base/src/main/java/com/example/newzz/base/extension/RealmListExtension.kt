package com.example.newzz.base.extension

import io.realm.RealmList

// MARK: - RealmList
fun <T> RealmList<T>.convertToList(): List<T> {
    val list: MutableList<T> = mutableListOf()
    for (i in indices) { this[i]?.let { list.add(it) } }
    return list
}