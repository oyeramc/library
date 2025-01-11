package com.oyera.domain.value.objects

import kotlinx.serialization.Serializable
import java.util.regex.Pattern

@Serializable
class Email(val email: String) {
    override fun toString(): String {
        return format(email)
    }

    init {
        if (!isValidEmail(email)) {
            throw IllegalArgumentException("Invalid email format")
        }

    }

    companion object {
        private fun isValidEmail(email: String): Boolean {
            val emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$"
            val pattern = Pattern.compile(emailRegex)
            val matcher = pattern.matcher(email)
            return matcher.matches()
        }

        private fun format(value: String): String {
            return value.trim()
        }


    }
}