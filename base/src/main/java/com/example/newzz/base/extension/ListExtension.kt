package com.example.newzz.base.extension

import io.realm.RealmList

// MARK: - List
fun <T> List<T>.convertToRealmList(): RealmList<T> {
    val realmList = RealmList<T>()
    for (i in indices) { realmList.add(this[i]) }
    return realmList
}

fun <T> List<T>.hasContents(): Boolean = !this.isNullOrEmpty()