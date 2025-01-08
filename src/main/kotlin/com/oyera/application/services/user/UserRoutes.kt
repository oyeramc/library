package com.oyera.application.services.user

import com.oyera.domain.entities.User
import com.oyera.domain.repository.UserRepository
import com.oyera.infra.database.dto.UserRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userRouting() {
    val repo = UserRepository()

    routing {

        route("/user") {
            get {
                call.respond(HttpStatusCode.OK, repo.findAll())
            }

            post {
                val req = call.receive<UserRequest>()
                val newUser = User(
                    firstName = req.firstName,
                    lastName = req.lastName,
                    email = req.email,
                    password = req.password
                )

                repo.save(newUser)
                call.respond(HttpStatusCode.Created, newUser)
            }


            route("/{id}") {
                get {
                    val id = call.parameters["id"]!!
                    call.respond(repo.findById(id) ?: throw NotFoundException("User not found"))
                }

                delete {
                    val id = call.parameters["id"]!!
                    repo.delete(id)
                    call.respond(HttpStatusCode.NoContent)
                }

                put<User> {
                    val user = call.receive<User>()
                }
            }

        }


    }
}