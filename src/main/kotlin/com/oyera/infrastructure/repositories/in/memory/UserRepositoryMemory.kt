package com.oyera.infrastructure.repositories.`in`.memory

import com.oyera.domain.entities.User
import com.oyera.domain.entities.UserType
import com.oyera.infrastructure.repositories.Repository


class UserRepositoryMemory : Repository<User> {
    init {
        _instance.add(newUser)
    }

    override suspend fun findAll(): List<User> {
        return _instance.toList()
    }

    override suspend fun findById(id: String): User? {
        return _instance.find { it.id == id }
    }

    override suspend fun save(input: User): User {
        _instance.add(input)
        return input
    }

    override suspend fun deleteById(id: String) {
        _instance.removeIf { it.id == id }
    }


    companion object {
        private var _instance: MutableList<User> = mutableListOf()
        internal var newUser: User = User(
            userType = UserType.COMMON,
            firstName = "John",
            lastName = "Doe",
            email = "john.doe@example.com",
            password = "password",
        )
    }

}