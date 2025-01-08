package com.oyera.application.services.book

import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.BookRoutes() {
    routing {
        route("/book") {

            route("/{id}") {
                get {

                }

                delete {

                }

            }
        }
    }
}