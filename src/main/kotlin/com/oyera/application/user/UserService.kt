package com.oyera.application.user

import com.oyera.shared.commom.interfaces.Validator
import com.oyera.domain.entities.User
import com.oyera.infrastructure.repositories.Repository
import com.oyera.interfaces.dto.UserRequest

class UserService(
    private val validator: Validator<UserRequest>,
    private val repository: Repository<User>
) {
    suspend fun create(userRequest: UserRequest): User {
        validator.validate(userRequest)
        val user = User(
            email = userRequest.email,
            firstName = userRequest.firstName,
            lastName = userRequest.lastName,
            password = userRequest.password,
        )
        repository.save(user)
        return user
    }
}