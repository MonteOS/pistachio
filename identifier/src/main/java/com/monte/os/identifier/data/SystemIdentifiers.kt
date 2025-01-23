package com.monte.os.identifier.data

import com.monte.os.identifier.Item
import com.monte.os.identifier.LongListItem
import com.monte.os.identifier.SimpleItem
import com.monte.os.identifier.data.system.SystemRepository
import javax.inject.Inject

interface SystemIdentifiers {

    fun list(): List<Item>

    class Base @Inject constructor(
        private val repository: SystemRepository
    ) : SystemIdentifiers {
        override fun list(): List<Item> {
            return listOf(
                SimpleItem("Manufacturer", repository.manufacturer()),
                SimpleItem("Brand", repository.brand()),
                SimpleItem("Model", repository.model()),
                SimpleItem("Android Version", repository.androidVersion()),
                SimpleItem("API", repository.api()),
                SimpleItem("Device", repository.device()),
                SimpleItem("Product", repository.product()),
                SimpleItem("Board", repository.board()),
                SimpleItem("Platform", repository.platform()),
                SimpleItem("Java VM", repository.javaVM()),
                SimpleItem("Fingerprint", repository.fingerprint()),
                SimpleItem("Build Date", repository.buildDate()),
                SimpleItem("Builder", repository.builder()),
                SimpleItem("Architecture", repository.architecture()),
                SimpleItem("Instruction sets", repository.instructionSets()),
                SimpleItem("Toybox", repository.toyboxVersion()),
//                LongListItem("Services List", repository.systemServices()),
//                LongListItem("System Settings", repository.systemSettings()),
//                LongListItem("Global Settings", repository.globalSettings()),
//                LongListItem("Secure Settings", repository.secureSettings()),
//                LongListItem("Properties", repository.allProperties())
            )
        }
    }
}
