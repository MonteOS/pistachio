package com.monte.os.identifier.battery

import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import javax.inject.Inject

class BatteryModule @Inject constructor(
    private val repository: BatteryRepository
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
            Item("Level", "${repository.level()}%")
        )
    }
}