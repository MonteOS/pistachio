package com.monte.os.identifier.data.appscope

interface AppScopeRepository {

    fun installationDate(): String

    fun appId(): String

    fun fullAppId(): String

    fun androidId(): String

}