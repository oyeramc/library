package com.oyera.domain.entities

import com.oyera.domain.value.objects.Languages
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val birthDate: LocalDateTime,
    val booksCount: Int,
    val bookList: MutableList<Book>,
    val image: String,
    val genres: MutableList<String>,
    val language: MutableList<Languages>
) {
}