package com.oyera.infrastructure.persistence

import com.oyera.domain.entities.UserType
import org.jetbrains.exposed.sql.Table

object UsersTable : Table("users") {
    val id = varchar("id", 255)
    val userType = enumeration("userType", UserType::class)
    val firstName = varchar("firstName", 255)
    val lastName = varchar("lastName", 255)
    val email = varchar("email", 255)
    val password = varchar("password", 255)

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}