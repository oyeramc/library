package com.oyera.interfaces.routes

import com.oyera.application.user.UserRequestValidation
import com.oyera.application.user.UserService
import com.oyera.domain.entities.User
import com.oyera.infrastructure.repositories.database.UserRepositoryImplement
import com.oyera.infrastructure.repositories.`in`.memory.UserRepositoryMemory
import com.oyera.interfaces.dto.UserRequest
import com.oyera.shared.commom.interfaces.Validator
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.userRouting() {
    val service = UserService(
        validator = UserRequestValidation(),
        repository = UserRepositoryImplement()
    )

    routing {

        route("/user") {
            get {
//                call.respond(HttpStatusCode.OK, ser.findAll())
            }

            post {
                try {
                    val req = call.receive<UserRequest>()
                    val newUser = service.create(req)
                    call.respond(HttpStatusCode.Created, newUser)
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message ?: "Unknown error")
                }

            }


//            route("/{id}") {
//                get {
//                    val id = call.parameters["id"]!!
//                    call.respond(repo.findById(id) ?: throw NotFoundException("User not found"))
//                }
//
//                delete {
//                    val id = call.parameters["id"]!!
//                    repo.deleteById(id)
//                    call.respond(HttpStatusCode.NoContent)
//                }
//
//                put<User> {
//                    val user = call.receive<User>()
//                }
//            }

        }


    }
}