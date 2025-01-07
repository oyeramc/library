package com.oyera.infra.interfaces.repositories

interface Repository<T> {
    suspend fun findAll(): List<T>

    suspend fun save(objectToBeSaved: T)

    suspend fun findById(id: String): T?

    suspend fun delete(id: String)

}