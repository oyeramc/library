package com.oyera.domain.repository

import com.oyera.domain.entities.User
import com.oyera.domain.factories.database.DatabaseFactory
import com.oyera.infra.database.dao.UserDao
import com.oyera.infra.interfaces.repositories.Repository

class UserRepository : Repository<User> {

    override suspend fun findAll(): List<User> {
        return UserDao().findAll()
    }

    override suspend fun delete(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun findById(id: String): User? {
        TODO("Not yet implemented")
    }

    override suspend fun save(objectToBeSaved: User) {
        UserDao().save(objectToBeSaved)
    }
}