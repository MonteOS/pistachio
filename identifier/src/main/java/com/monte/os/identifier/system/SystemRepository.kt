package com.monte.os.identifier.system

interface SystemRepository {

    fun architecture(): String

    fun toyboxVersion(): String

    fun javaVM(): String

    fun security(): String

    fun kernelVersion(): String

    fun buildDate(): String

    fun language(): String

    fun timezone(): String
}
