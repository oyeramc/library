package com.oyera.domain.value.objects

import at.favre.lib.crypto.bcrypt.BCrypt

object Password {
    fun String.hashPassword(): String {
        return BCrypt.withDefaults().hashToString(12, this.toCharArray())
    }
}