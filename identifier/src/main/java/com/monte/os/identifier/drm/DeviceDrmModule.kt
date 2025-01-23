package com.monte.os.identifier.drm

import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import com.monte.os.identifier.data.drm.DrmRepository
import javax.inject.Inject

class DeviceDrmModule @Inject constructor(
    private val repository: DrmRepository
): ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
            Item("DRM unique ID", repository.drmId()),
            Item("Widevine Vendor", repository.widevineVendor()),
            Item("Widevine Version", repository.widevineVersion()),
            Item("Widevine Algorithms", repository.widevineAlgorithms()),
        )
    }
}