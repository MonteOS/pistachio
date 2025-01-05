package com.monte.os.pistachio.identifiers

import com.monte.os.pistachio.identifiers.system.SystemRepository
import javax.inject.Inject

interface BuildIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val repository: SystemRepository
    ): BuildIdentifiers {
        override fun list(): List<Pair<String, String>> {
            return listOf(
                "Kernel" to repository.kernelVersion(),
                "Baseband" to repository.baseband(),
                "Build name" to repository.build(),
                "Build Type" to repository.buildType(),
                "Tags" to repository.tags(),
                "Incremental" to repository.incremental(),
                "Description" to repository.description(),
                "Security Patch" to repository.security(),
            )
        }
    }
}
