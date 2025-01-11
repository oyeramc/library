package com.oyera.domain.value.objects

import kotlinx.serialization.Serializable

@Serializable
class ISBN private constructor(val isbnString: String) {

    companion object {
        val isbnRegex = Regex(
            "^(?:ISBN(?:-1[03])?:? )?(?:97[89])?-?[0-9]{1,5}-?[0-9]+-?[0-9]+-?[0-9X]\$"
        )

        fun create(isbn: String): ISBN {
            if (!checkIsbn(isbn)) {
                throw IllegalArgumentException("ISBN não é válido.")
            }
            return ISBN(isbn)
        }

        fun checkIsbn(isbn: String): Boolean {
            return isbnRegex.matches(isbn)
        }
    }
}
