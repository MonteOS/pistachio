package com.monte.os.identifier.drm

import android.media.MediaDrm
import java.security.MessageDigest
import java.util.UUID
import javax.inject.Inject

class DrmInfo @Inject constructor(
) : DrmRepository {

    private val widevine = MediaDrm(WIDEVINE_UUID)

    override fun widevineVendor(): String {
        return widevine.getPropertyString(
            MediaDrm.PROPERTY_VENDOR
        )
    }

    override fun widevineVersion(): String {
        return widevine.getPropertyString(
            MediaDrm.PROPERTY_VERSION
        )
    }

    override fun widevineAlgorithms(): String {
        return widevine.getPropertyString(
            MediaDrm.PROPERTY_ALGORITHMS
        )
    }

    override fun drmId(): String {
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