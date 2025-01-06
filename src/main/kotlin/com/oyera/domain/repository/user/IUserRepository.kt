package com.oyera.domain.repository.user

import com.oyera.domain.entities.user.User

interface IUserRepository {

    fun GetById(id: String): User


    fun save(user: User): Unit



}