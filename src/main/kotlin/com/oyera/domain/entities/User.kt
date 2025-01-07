package com.oyera.domain.entities

import com.oyera.domain.entities.user.UsersTable.password
import com.oyera.domain.value.objects.Id
import com.oyera.domain.value.objects.Password
import com.oyera.domain.value.objects.Password.hashPassword
import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: String = Id().newId,
    val firstName: String,
    val lastName: String,
    val email: String,
    var password: String,
    val userType: UserType,
    val loanHistory: MutableList<Loan> = mutableListOf(),
    val bookHistory: MutableList<Book> = mutableListOf(),
    val activeBooks: MutableList<Book> = mutableListOf()
) {

    init {
        password = password.hashPassword()
    }
}
