package com.oyera

import com.oyera.domain.entities.loan.Loan
import com.oyera.domain.entities.user.User
import com.oyera.domain.entities.user.UserType
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.cors.routing.*
import io.ktor.server.plugins.swagger.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import java.sql.Connection
import java.sql.DriverManager
import org.koin.dsl.module
import org.koin.ktor.plugin.Koin
import org.koin.logger.slf4jLogger
import org.slf4j.event.*

fun Application.configureRouting() {
    install(ContentNegotiation) {
        json(Json {
            prettyPrint = true
        })
    }

    routing {
        swaggerUI("swagger", "openapi/documentation.yaml")
        get("/") {
            val user =
                User("luan",
                "henrique",
                        "oyera.dev@gmail.com",
                    userType = UserType.ADM
                    )
            call.respond(user)
        }
    }
}
