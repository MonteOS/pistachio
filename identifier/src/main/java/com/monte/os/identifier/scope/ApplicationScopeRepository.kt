package com.monte.os.identifier.scope

interface ApplicationScopeRepository {
    fun installationDate(): String

    fun fullAppId(): String

    fun androidId(): String
}