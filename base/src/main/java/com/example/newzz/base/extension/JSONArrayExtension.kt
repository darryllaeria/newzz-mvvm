package com.example.newzz.base.extension

import org.json.JSONArray
import org.json.JSONObject

// MARK: - JSONArray
fun JSONArray.toListJSONObject(): List<JSONObject> = List(length(), this::getJSONObject)

fun JSONArray.toListAny(): List<Any> = List(length(), this::get)

fun JSONArray.sortDoubleValueUsing(key: String): MutableList<JSONObject> {
    var jsonList = mutableListOf<JSONObject>()
    for (i in 0 until this.length())
        jsonList.add(this.optJSONObject(i))
    jsonList.sortBy { it.optDouble(key) }
    return jsonList
}