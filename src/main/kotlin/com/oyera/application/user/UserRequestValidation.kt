package com.oyera.application.user

import com.oyera.shared.commom.interfaces.Validator
import com.oyera.interfaces.dto.UserRequest

class UserRequestValidation : Validator<UserRequest> {
    override fun validate(input: UserRequest) {
        when {
            input.firstName.isBlank() -> throw Exception("First name is required")
            input.email.isBlank() -> throw Exception("Email is required")
            input.lastName.isBlank() -> throw Exception("Last name is required")
            input.password.isBlank() -> throw Exception("Password is required")
        }
    }
}