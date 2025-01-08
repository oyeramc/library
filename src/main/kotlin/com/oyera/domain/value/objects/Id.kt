package com.oyera.domain.value.objects

import java.util.UUID

@JvmInline
value class Id(private val id: UUID = UUID.randomUUID()) {
    override fun toString(): String = id.toString()
}