package com.monte.os.identifier.battery

import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import javax.inject.Inject

class BatteryModule @Inject constructor(
    private val repository: BatteryRepository
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
            Item("Started capacity", "${repository.startedCapacity()} mAh"),
            Item("Estimated capacity", "${repository.estimatedCapacity()} mAh"),
            Item("Cycles count", "${repository.cyclesCount() ?: "Undefined"}"),
            Item("Level", "${repository.level()}%")
        )
    }
}
