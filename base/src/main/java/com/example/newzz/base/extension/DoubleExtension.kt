package com.example.newzz.base.extension

import kotlin.math.absoluteValue

// MARK: - Double
fun Double.isPositive(): Boolean = this >= 0

/// Returns a String value of Double with no decimal.
fun Double.noDecimalFormatted(): String = withSpace()

/// Returns a String value of Double to 2 decimal places if Double has 1 or more digits, otherwise returns a String value of Double to 5 decimal places.
fun Double.shortFormatted(): String = withSpace(if (this.absoluteValue >= 1) 2 else 5)

fun Double.withSpace(decimalPlaces: Int = 0): String = "%.${decimalPlaces}f".format(this)