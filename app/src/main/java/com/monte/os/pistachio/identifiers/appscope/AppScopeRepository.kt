package com.monte.os.pistachio.identifiers.appscope

interface AppScopeRepository {

    fun installationDate(): String

    fun appId(): String

    fun androidId(): String

}