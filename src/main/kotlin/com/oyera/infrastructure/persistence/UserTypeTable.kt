package com.oyera.infrastructure.persistence

import com.oyera.domain.entities.UserType
import org.jetbrains.exposed.sql.Table

object UserTypeTable : Table("user_type") {
    val userType = enumeration<UserType>("type_code")

    override val primaryKey = PrimaryKey(userType)
}