package com.example.newzz.base.extension

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// MARK: - EditText
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

fun EditText.hideKeyboard(time: Long = 0L) {
    CoroutineScope(Dispatchers.Main).launch {
        delay(time)
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}

fun EditText.replaceLast(toReplaceText: String, replaceText: String) {
    val currentText = this.text.toString()
    currentText.lastRange(toReplaceText)?.let {
        this.setText(this.text.replaceRange(it, replaceText))
        this.setSelection(this.length())
    }
}

fun EditText.showKeyboard(time: Long = 0L) {
    val view = this
    CoroutineScope(Dispatchers.Main).launch {
        delay(time)
        if (requestFocus()) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}

fun EditText.setupCursorEvents() {
    setOnEditorActionListener { _, actionId, _ ->
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            isCursorVisible = false
            true
        }
        false
    }
    setOnFocusChangeListener { _, hasFocus ->
        if (!hasFocus) { hideKeyboard() }
        isCursorVisible = hasFocus
    }
}