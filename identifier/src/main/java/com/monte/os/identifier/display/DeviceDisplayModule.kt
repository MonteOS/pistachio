package com.monte.os.identifier.display

import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import javax.inject.Inject

class DeviceDisplayModule @Inject constructor(
    private val repository: ScreenRepository
): ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
            Item("Resolution", repository.resolution()),
            Item("Density", repository.density()),
            Item("X DPI", repository.xDPI()),
            Item("Y DPI", repository.yDPI()),
            Item("Refresh rate", repository.refreshRate())
        )
    }
}