package com.monte.os.pistachio.identifiers.appscope

interface AppScopeRepository {

    fun installationDate(): String

    fun androidId(): String

}