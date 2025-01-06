package com.monte.os.pistachio.identifiers

import com.monte.os.pistachio.identifiers.appscope.AppScopeRepository
import javax.inject.Inject

interface AppLifetimeScopeIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val repository: AppScopeRepository
    ): AppLifetimeScopeIdentifiers {
        override fun list(): List<Pair<String, String>> {
            return listOf(
                "App Installation Time" to repository.installationDate(),
                "App ID" to repository.appId(),
            )
        }
    }

}
