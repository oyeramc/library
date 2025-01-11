package com.oyera.infrastructure.database

import com.oyera.infrastructure.persistence.UsersTable
import com.oyera.infrastructure.persistence.BookTable
import com.oyera.infrastructure.persistence.LanguageTable
import com.oyera.infrastructure.persistence.UserTypeTable
import io.ktor.server.engine.applicationEnvironment
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {
    private val env = applicationEnvironment()

    private lateinit var url: String;
    private lateinit var user: String
    private lateinit var password: String;
    private lateinit var driver: String;

    fun init(url: String, user: String, password: String, driver: String) {
        this.url = url
        this.user = user
        this.password = password
        this.driver = driver

        pgConnect()
        transaction {
            SchemaUtils.create(UsersTable, LanguageTable, BookTable, UserTypeTable)
        }
    }

    private fun pgConnect() = Database.Companion.connect(
        url = url, driver = driver, user = user, password = password
    )

    suspend fun <T> dbQuery(block: () -> T): T = newSuspendedTransaction(Dispatchers.IO) {
        block()
    }

}