package com.monte.os.identifier.data.system

interface SystemRepository {

    fun architecture(): String

    fun toyboxVersion(): String

    fun platform(): String

    fun javaVM(): String

    fun security(): String

    fun kernelVersion(): String

    fun description(): String

    fun buildDate(): String

    fun language(): String

    fun timezone(): String

    fun systemServices(): List<String>

    fun allProperties(): List<String>
}
