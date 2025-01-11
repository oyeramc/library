package com.oyera.infrastructure.repositories


interface Repository<T> {
    suspend fun save(input: T): T
    suspend fun findById(id: String): T?
    suspend fun findAll(): List<T>
    suspend fun deleteById(id: String)
}