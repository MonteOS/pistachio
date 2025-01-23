package com.monte.os.identifier

import com.monte.os.identifier.appscope.AppScopeRepository
import javax.inject.Inject

interface DeviceIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val appScope: AppScopeRepository,
    ) : DeviceIdentifiers {
        override fun list(): List<Pair<String, String>> {
            return listOf(
                "Android ID" to appScope.androidId(),
            )
        }
    }
}
