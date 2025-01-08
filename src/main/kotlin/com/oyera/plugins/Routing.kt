package com.oyera.plugins

import com.oyera.application.services.user.userRouting
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    userRouting()
    routing {
        get("/") {
            call.respondText("Hello World!", ContentType.Text.Plain)
        }
    }
}
