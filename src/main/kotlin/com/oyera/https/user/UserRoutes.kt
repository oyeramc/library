package com.oyera.https.user

import com.oyera.domain.entities.User
import com.oyera.domain.repository.user.UserRepository
import com.oyera.domain.repository.user.UserRepositoryMemory
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userRouting() {
    val repo: UserRepository = UserRepository()

    routing {

        route("/user") {
            get {
                call.respond(HttpStatusCode.OK, repo.findAll())
            }

            post {
                val user = call.receive<User>()

                repo.save(user)
                call.respond(HttpStatusCode.Created, user)
            }


            route("/{id}") {
                get {
                    val id = call.parameters["id"]!!
                    call.respond(repo.findById(id) ?: throw NotFoundException("User not found"))
                }

                delete {
                    val id = call.parameters["id"]!!
                    repo.delete(id) ?: throw NotFoundException("User not found")
                    call.respond(HttpStatusCode.NoContent)
                }

                put<User> {
                    val user = call.receive<User>()
                }
            }

        }


    }
}