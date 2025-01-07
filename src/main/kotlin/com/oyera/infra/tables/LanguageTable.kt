package com.oyera.infra.tables

import com.oyera.domain.value.objects.Languages
import org.jetbrains.exposed.sql.Table

object LanguageTable : Table("languages") {
    val languages = enumeration<Languages>("lang_code")

    override val primaryKey = PrimaryKey(languages)
}