package com.oyera.domain.value.objects

import java.util.UUID

@JvmInline
value class Id(val newId: String = UUID.randomUUID().toString())