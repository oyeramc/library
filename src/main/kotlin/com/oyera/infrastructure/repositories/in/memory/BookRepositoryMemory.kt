package com.oyera.infrastructure.repositories.`in`.memory

import com.oyera.domain.entities.Book
import com.oyera.domain.value.objects.GenreTypes
import com.oyera.infrastructure.repositories.Repository
import kotlinx.datetime.LocalDate

class BookRepositoryMemory : Repository<Book> {
    init {
        _instance.add(exampleBook)
    }

    override suspend fun findAll(): List<Book> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun findById(id: String): Book {
        TODO("Not yet implemented")
    }

    override suspend fun save(input: Book): Book {
        TODO("Not yet implemented")
    }

    companion object {
        val _instance: MutableList<Book> = mutableListOf()
        val exampleBook: Book = Book(
            description = "Teste",
            title = "Crime e castigo",
            author = "Fiodor Dostoevsky",
            genres = listOf(GenreTypes.NOVEL, GenreTypes.DETECTIVE),
            releaseDate = LocalDate(year = 1866, monthNumber = 12, dayOfMonth = 7),
            isbn = null,
            quantity = 12,
            isAvailable = true,
            isActiveInUserAccount = true
        )
    }

}