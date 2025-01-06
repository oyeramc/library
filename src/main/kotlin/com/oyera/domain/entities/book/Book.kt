package com.oyera.domain.entities.book

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Book(val title: String, val description: String, val author: String,
    val releaseDate: LocalDateTime
    ) {


}