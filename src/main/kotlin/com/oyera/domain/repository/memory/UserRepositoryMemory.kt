package com.oyera.domain.repository.memory

import com.oyera.domain.entities.User
import com.oyera.domain.entities.UserType
import com.oyera.infra.interfaces.repositories.Repository
import com.oyera.domain.repository.memory.UserRepositoryMemory

class UserRepositoryMemory : Repository<User> {
    init {
        newUser.activeBooks.add(BookRepositoryMemory.exampleBook)
    }

    init {
        _instance.add(newUser)
    }

    override suspend fun findAll(): List<User> {
        return _instance.toList()
    }

    override suspend fun findById(id: String): User? {
        return _instance.find { it.id == id }
    }

    override suspend fun save(objectToBeSaved: User) {
        _instance.add(objectToBeSaved)
    }

    override suspend fun delete(id: String) {
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