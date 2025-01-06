package com.oyera.domain.value.objects

import java.util.UUID

class Id() {
    companion object {
        val newId: String = UUID.randomUUID().toString()
    }

}