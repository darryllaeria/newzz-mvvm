package com.example.newzz.base.extension

// MARK: - ByteArray
fun ByteArray.asHexLower(): String = this.joinToString(separator = ""){ String.format("%02x",(it.toInt() and 0xFF))}

fun ByteArray.asHexUpper(): String = this.joinToString(separator = ""){ String.format("%02X",(it.toInt() and 0xFF))}