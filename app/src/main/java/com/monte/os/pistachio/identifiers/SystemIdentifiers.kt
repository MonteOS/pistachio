package com.monte.os.pistachio.identifiers

import com.monte.os.pistachio.identifiers.system.SystemRepository
import javax.inject.Inject

interface SystemIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val repository: SystemRepository
    ): SystemIdentifiers {
        override fun list(): List<Pair<String, String>> {
            return listOf(
                "Manufacturer" to repository.manufacturer(),
                "Brand" to repository.brand(),
                "Model" to repository.model(),
                "Release" to repository.release(),
                "API" to repository.api(),
                "Device" to repository.device(),
                "Product" to repository.product(),
                "Board" to repository.board(),
                "Platform" to repository.platform(),
                "Java VM" to repository.javaVM(),
                "Fingerprint" to repository.fingerprint(),
                "Build Date" to repository.buildDate(),
                "Builder" to repository.builder(),
                "Architecture" to repository.architecture(),
                "Instruction sets" to repository.instructionSets(),
                "Toybox" to repository.toyboxVersion()
            )
        }
    }
}
