package com.monte.os.pistachio.identifiers.appscope

interface AppScopeRepository {

    fun installationDate(): String

    fun appId(): String

    fun fullAppId(): String

    fun androidId(): String

}