package com.oyera.infra.database.dao

import com.oyera.domain.entities.User
import com.oyera.domain.entities.UserType
import com.oyera.domain.entities.user.UsersTable
import com.oyera.domain.entities.user.UsersTable.email
import com.oyera.domain.entities.user.UsersTable.firstName
import com.oyera.domain.entities.user.UsersTable.id
import com.oyera.domain.entities.user.UsersTable.lastName
import com.oyera.domain.entities.user.UsersTable.password
import com.oyera.domain.entities.user.UsersTable.userType
import com.oyera.domain.factories.database.DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

class UserDao {
    suspend fun findAll(): List<User> = dbQuery {
        UsersTable.selectAll().map {
            User(
                id = it[id],
                firstName = it[firstName],
                lastName = it[lastName],
                email = it[email],
                password = it[password],
                userType = it[userType],
            )
        }
    }

    suspend fun save(user: User) = dbQuery {
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