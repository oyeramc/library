package com.oyera.infrastructure.repositories.database

import com.oyera.domain.entities.User
import com.oyera.infrastructure.persistence.UserDao
import com.oyera.infrastructure.repositories.Repository

class UserRepositoryImplement : Repository<User> {
    override suspend fun save(user: User): User {


        try {
            db.save(user)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return user
    }

    override suspend fun findById(id: String): User? {
        TODO()
    }

    override suspend fun findAll(): List<User> {
        return db.findAll().toList()
    }


    override suspend fun deleteById(id: String) {
        TODO("Not yet implemented")
    }

    companion object {
        val db = UserDao()
    }
}