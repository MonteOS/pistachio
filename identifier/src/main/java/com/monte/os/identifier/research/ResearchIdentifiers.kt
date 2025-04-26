package com.monte.os.identifier.research

import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import com.monte.os.identifier.battery.BatteryRepository
import com.monte.os.identifier.drm.DrmRepository
import com.monte.os.identifier.scope.ApplicationScopeRepository
import javax.inject.Inject

class ResearchIdentifiers @Inject constructor(
    private val appScopeRepository: ApplicationScopeRepository,
    private val drmRepository: DrmRepository,
    private val batteryRepository: BatteryRepository
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
            Item("User and group ID", appScopeRepository.fullAppId()),
            Item("Android ID", appScopeRepository.androidId()),
            Item("DRM ID", drmRepository.drmId()),
            Item("Battery estimated capacity", "${batteryRepository.estimatedCapacity()} mAh"),
            Item("Battery cycles count", "${batteryRepository.cyclesCount() ?: "Undefined"}")
        )
    }
}
