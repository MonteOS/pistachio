package com.monte.os.identifier.drm

import android.media.MediaDrm
import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import java.security.MessageDigest
import java.util.UUID
import javax.inject.Inject

class DeviceDrmModule @Inject constructor(
): ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
            Item("DRM unique ID", drmId()),
            Item("Widevine Vendor", widevineVendor()),
            Item("Widevine Version", widevineVersion()),
            Item("Widevine Algorithms", widevineAlgorithms()),
        )
    }

    private val widevine = MediaDrm(WIDEVINE_UUID)

    private fun widevineVendor(): String {
        return widevine.getPropertyString(
            MediaDrm.PROPERTY_VENDOR
        )
    }

    private fun widevineVersion(): String {
        return widevine.getPropertyString(
            MediaDrm.PROPERTY_VERSION
        )
    }

    private fun widevineAlgorithms(): String {
        return widevine.getPropertyString(
            MediaDrm.PROPERTY_ALGORITHMS
        )
    }

    private fun drmId(): String {
        val deviceUniqueId = widevine.getPropertyByteArray(
            MediaDrm.PROPERTY_DEVICE_UNIQUE_ID
        )
        val messageDigest = MessageDigest.getInstance("SHA-256")
        messageDigest.update(deviceUniqueId)
        return messageDigest.digest().joinToString("") {
            java.lang.String.format("%02x", it)
        }
    }

    companion object {
        private val WIDEVINE_UUID = UUID(
            -0x121074568629b532L,
            -0x5c37d8232ae2de13L
        )
    }
}