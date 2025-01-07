package com.oyera.domain.repository.user

import com.oyera.domain.entities.User
import com.oyera.infra.interfaces.repositories.Repository

class UserRepositoryMemory : Repository<User> {


    suspend override fun findAll(): List<User> {
        return _instance.toList()
    }

    suspend override  fun findById(id: String): User? {
        return _instance.find { it.id == id }
    }

    override suspend fun save(user: User) {
        _instance.add(user)
    }

    override suspend fun delete(id: String) {
        _instance.removeIf { it.id == id }
    }


    companion object {
        private var _instance: MutableList<User> = mutableListOf()
        val repository: UserRepositoryMemory = UserRepositoryMemory()
    }

}