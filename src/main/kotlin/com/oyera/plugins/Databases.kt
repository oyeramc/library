package com.oyera.plugins


import com.oyera.domain.factories.database.DatabaseFactory
import io.ktor.server.application.*

fun Application.configureDatabases() {
    val url = environment.config.property("postgres.url").getString()
    val user = environment.config.property("postgres.user").getString()
    val password = environment.config.property("postgres.password").getString()
    val driver = environment.config.property("postgres.driverClass").getString()

    DatabaseFactory.init(url = url, user = user, password = password, driver = driver)
}