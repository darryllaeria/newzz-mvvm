package com.example.newzz.base.utils

import android.util.Patterns
import com.example.newzz.base.Constants
import java.util.regex.Pattern

object Validator {

    fun isValidateEmail(email: String): Boolean {
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun validatePasswordLength(password: String): Boolean {
        return password.isNotEmpty() && password.length >= Constants.PASSWORD_LENGTH
    }

    fun validateCasePassword(password: String): Boolean {
        return hasUpperCase(password) && hasLowerCase(password)
    }

    fun validateSpecialCharacter(password: String): Boolean {
        val pattern = Pattern.compile("[!@#\$%&*()_+=|<>?{}\\\\[\\\\]~-]")
        return pattern.matcher(password).find()
    }

    fun isValidateUsername(userName: String): Boolean {
        val pattern = Pattern.compile("^[a-zA-Z0-9_]{5,20}$")
        return pattern.matcher(userName).find()
    }

    private fun hasUpperCase(password: String): Boolean {
        val pattern = Pattern.compile(".*[A-Z].*")
        return pattern.matcher(password).find()
    }

    private fun hasLowerCase(password: String): Boolean {
        val pattern = Pattern.compile(".*[a-z].*")
        return pattern.matcher(password).find()
    }
}