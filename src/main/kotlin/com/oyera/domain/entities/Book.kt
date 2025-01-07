package com.oyera.domain.entities

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Book(
    val title: String,
    val description: String,
    val author: String,
    val releaseDate: LocalDateTime,
    val genres: List<String>,
) {


}
