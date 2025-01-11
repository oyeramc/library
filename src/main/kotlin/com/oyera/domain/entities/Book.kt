package com.oyera.domain.entities

import com.oyera.domain.value.objects.GenreTypes
import com.oyera.domain.value.objects.ISBN
import com.oyera.domain.value.objects.Id
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val isbn: ISBN? = null,
    val id: String = Id().toString(),
    val title: String,
    val description: String,
    val author: String,
    val releaseDate: LocalDate,
    val quantity: Int,
    val genres: List<GenreTypes>,
    val isAvailable: Boolean,
    val isActiveInUserAccount: Boolean,
)
