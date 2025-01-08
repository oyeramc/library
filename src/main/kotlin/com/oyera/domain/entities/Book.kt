package com.oyera.domain.entities

import com.oyera.domain.value.objects.GenreTypes
import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val title: String,
    val description: String,
    val author: String,
    val releaseDate: LocalDate,
    val genres: List<GenreTypes>,
)
