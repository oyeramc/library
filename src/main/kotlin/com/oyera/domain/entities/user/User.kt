package com.oyera.domain.entities.user

import com.oyera.domain.entities.book.Book
import com.oyera.domain.entities.loan.Loan
import com.oyera.domain.value.objects.Id
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val userType: UserType,
    val loanHistory: MutableList<Loan> = mutableListOf(),
    val bookHistory: MutableList<Book> = mutableListOf(),
    val activeBooks: MutableList<Book> = mutableListOf(),
    val id: String = Id.newId
)
