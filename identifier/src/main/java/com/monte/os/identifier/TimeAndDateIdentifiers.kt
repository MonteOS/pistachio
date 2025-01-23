package com.monte.os.identifier

import com.monte.os.identifier.system.SystemRepository
import javax.inject.Inject

interface TimeAndDateIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val repository: SystemRepository
    ) : TimeAndDateIdentifiers {
        override fun list(): List<Pair<String, String>> {
            return listOf(
                "Language" to repository.language(),
                "Timezone" to repository.timezone()
            )
        }
    }
}