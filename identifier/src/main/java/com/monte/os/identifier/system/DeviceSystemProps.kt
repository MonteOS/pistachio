package com.monte.os.identifier.system

import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import javax.inject.Inject

class DeviceSystemProps @Inject constructor(
    private val repository: SystemRepository
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
            Item("Manufacturer", repository.manufacturer()),
            Item("Brand", repository.brand()),
            Item("Model", repository.model()),
            Item("Android Version", repository.androidVersion()),
            Item("API", repository.api()),
            Item("Device", repository.device()),
            Item("Product", repository.product()),
            Item("Board", repository.board()),
            Item("Java VM", repository.javaVM()),
            Item("Fingerprint", repository.fingerprint()),
            Item("Build Date", repository.buildDate()),
            Item("Builder", repository.builder()),
            Item("Architecture", repository.architecture()),
            Item("Instruction sets", repository.instructionSets()),
            Item("Toybox", repository.toyboxVersion()),
        )
    }
}
