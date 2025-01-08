package com.oyera.infra.interfaces.repositories


interface Repository<Entity> {
    suspend fun findAll(): List<Entity>

    suspend fun save(objectToBeSaved: Entity)

    suspend fun findById(id: String): Entity?

    suspend fun delete(id: String)

}