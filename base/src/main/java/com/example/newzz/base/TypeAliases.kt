package com.example.newzz.base

// MARK: - Callbacks
typealias EmptyCallback = () -> Unit
typealias ErrorStringCallback = (String) -> Unit
typealias StringCallback = (String) -> Unit
typealias SuccessCallback = (Boolean) -> Unit

// MARK: - Types
typealias JSONMutableMap = MutableMap<String, Any?>