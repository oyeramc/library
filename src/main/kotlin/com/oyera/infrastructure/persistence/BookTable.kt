package com.oyera.infrastructure.persistence

import org.jetbrains.exposed.sql.Table

object BookTable : Table("books") {
    val userId = varchar("id", 64)
    val authorId = varchar("author_id", 64)
    val title = varchar("title", 64)
    val authorName = varchar("author_name", 64)
    val publishedDate = varchar("published_date", 64)
}