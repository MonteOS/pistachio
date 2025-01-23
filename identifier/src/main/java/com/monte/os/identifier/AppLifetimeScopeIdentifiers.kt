package com.monte.os.identifier

import com.monte.os.identifier.appscope.AppScopeRepository
import javax.inject.Inject

interface AppLifetimeScopeIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val repository: AppScopeRepository
    ) : AppLifetimeScopeIdentifiers {
        override fun list(): List<Pair<String, String>> {
            return listOf(
                "App Installation Time" to repository.installationDate(),
                "App User ID" to repository.appId(),
                "Current process IDs" to repository.fullAppId()
            )
        }
    }

}
