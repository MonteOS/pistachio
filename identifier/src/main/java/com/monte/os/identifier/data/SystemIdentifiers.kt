package com.monte.os.identifier.data

import com.monte.os.identifier.Item
import com.monte.os.identifier.data.system.SystemRepository
import javax.inject.Inject

interface SystemIdentifiers {

    fun list(): List<Item>

    class Base @Inject constructor(
        private val repository: SystemRepository
    ) : SystemIdentifiers {
        override fun list(): List<Item> {
            return listOf(
                Item(name = "Manufacturer", repository.manufacturer())
//                "Manufacturer" to repository.manufacturer(),
//                "Brand" to repository.brand(),
//                "Model" to repository.model(),
//                "Android Version" to repository.androidVersion(),
//                "API" to repository.api(),
//                "Device" to repository.device(),
//                "Product" to repository.product(),
//                "Board" to repository.board(),
//                "Platform" to repository.platform(),
//                "Java VM" to repository.javaVM(),
//                "Fingerprint" to repository.fingerprint(),
//                "Build Date" to repository.buildDate(),
//                "Builder" to repository.builder(),
//                "Architecture" to repository.architecture(),
//                "Instruction sets" to repository.instructionSets(),
//                "Toybox" to repository.toyboxVersion(),
//                "Services List" to repository.systemServices().joinToString("\n"),
//                "System Settings" to repository.systemSettings().joinToString("\n"),
//                "Global Settings" to repository.globalSettings().joinToString("\n"),
//                "Secure Settings" to repository.secureSettings().joinToString("\n"),
//                "Properties" to repository.allProperties().joinToString("\n")
            )
        }
    }
}
