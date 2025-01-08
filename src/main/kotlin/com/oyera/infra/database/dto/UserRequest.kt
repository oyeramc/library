package com.oyera.infra.database.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserRequest(
    val firstName: String,
    val lastName: String,
    val email: String,
    val password: String,
)