package com.oyera.domain.entities

import com.oyera.domain.value.objects.Email
import com.oyera.domain.value.objects.Id
import com.oyera.domain.value.objects.Password.hashPassword
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class User(
    val id: String = Id().toString(),
    var firstName: String,
    var lastName: String,
    var email: String,
    var password: String,
    var userType: UserType = UserType.COMMON,
    val loanHistory: MutableList<Loan> = mutableListOf<Loan>(),
    val bookHistory: MutableList<Book> = mutableListOf<Book>(),
) {
    init {


        this.firstName = this.firstName.formatName()
        this.lastName = this.lastName.formatName()
        this.password = this.password.hashPassword()
        this.email = Email(this.email).toString()
    }

    companion object {
        private fun String.formatName(): String {
            return this.trim()
                .lowercase()
                .replaceFirstChar {
                    it.titlecase(Locale.getDefault())
                }
        }
    }

}
