package com.example.newzz.base.extension

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

// MARK: - String
fun String.findMentionText(regex: String = "(@[a-zA-Z0-9_ \\x{00C0}-\\x{00FF}\\x{1EA0}-\\x{1EFF}\\p{N}]*)"): String? {
    return Regex(regex).findAll(this).map { it.groupValues[1] }.lastOrNull()
}

fun String.findMentionTextAndRange(regex: String = "(@[a-zA-Z0-9_ \\x{00C0}-\\x{00FF}\\x{1EA0}-\\x{1EFF}\\p{N}]*)"): Pair<String, IntRange>? {
    val last = Regex(regex).findAll(this).lastOrNull() ?: return null
    return Pair(last.groupValues[1], last.range)
}

fun String.findSuggestionText(): String {
    val lastString = this.getLastPhrase()
    return if (lastString.startsWith("@"))
        ""
     else
        lastString
}

fun String.firstRange(regex: String): IntRange? {
    val updatedRegex = regex.replace("(","\\(").replace(")","\\)")
    val regex = updatedRegex.toRegex()
    return regex.findAll(this).firstOrNull()?.range
}

fun String.getInitials(maxChars: Int): String {
    return this.split(" ").take(maxChars).fold("", { acc, s -> acc + s[0] })
}

fun String.getLastPhrase(): String = this.split(" ").lastOrNull() ?: ""

// Make sure the string is in hex format, otherwise the app will crash
fun String.hexStringToByteArray(): ByteArray = this.chunked(2).map { it.toUpperCase().toInt(16).toByte() }.toByteArray()

fun String.isValidJsonObject(): Boolean {
    return try {
        JSONObject(this)
        true
    } catch (e: JSONException) {
        false
    }
}

fun String.isValidJsonArray(): Boolean {
    return try {
        JSONArray(this)
        true
    } catch (e: JSONException) {
        false
    }
}

fun String.lastRange(regex: String): IntRange? {
    val updatedRegex = regex.replace("(","\\(").replace(")","\\)")
    val regex = updatedRegex.toRegex()
    return regex.findAll(this).lastOrNull()?.range
}

fun String.ranges(regex: String): List<IntRange> {
    val updatedRegex = regex.replace("(","\\(").replace(")","\\)")
    val regex = updatedRegex.toRegex()
    return regex.findAll(this).mapNotNull { it.range }.toList()
}

