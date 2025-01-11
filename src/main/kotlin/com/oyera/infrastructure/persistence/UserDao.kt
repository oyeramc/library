package com.oyera.infrastructure.persistence

import com.oyera.domain.entities.User
import com.oyera.infrastructure.database.DatabaseFactory
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class UserDao {
    suspend fun findAll(): List<User> = DatabaseFactory.dbQuery {
        UsersTable.selectAll().map {
            User(
                id = it[UsersTable.id],
                firstName = it[UsersTable.firstName],
                lastName = it[UsersTable.lastName],
                email = it[UsersTable.email],
                password = it[UsersTable.password],
                userType = it[UsersTable.userType],
            )
        }
    }

    suspend fun save(user: User) = DatabaseFactory.dbQuery {
        UsersTable.insert {
            it[firstName] = user.firstName
            it[lastName] = user.lastName
            it[email] = user.email
            it[password] = user.password
            it[userType] = user.userType
            it[id] = user.id
        }
    }
}