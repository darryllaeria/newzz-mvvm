package com.example.newzz.base.extension

// MARK: - IntRange
fun IntRange.isOverlap(withRange: IntRange): Boolean = this.last >= withRange.first && this.first <= withRange.last