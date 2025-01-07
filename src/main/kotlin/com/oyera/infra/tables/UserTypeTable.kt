package com.oyera.infra.tables

import com.oyera.domain.entities.UserType
import com.oyera.domain.value.objects.Languages
import org.jetbrains.exposed.sql.Table

object UserTypeTable : Table("user_type") {
    val userType = enumeration<UserType>("type_code")

    override val primaryKey = PrimaryKey(userType)
}