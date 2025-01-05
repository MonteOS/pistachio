package com.yawl.os.pistachio.drm

import android.media.MediaDrm
import android.util.Base64
import java.util.UUID
import javax.inject.Inject

class DrmInfo @Inject constructor(
) : DrmRepository {

    override fun drmId(): String {
        return Base64.encodeToString(
            MediaDrm(WIDEVINE_UUID).getPropertyByteArray(
                MediaDrm.PROPERTY_DEVICE_UNIQUE_ID
            ),
            Base64.DEFAULT
        )
    }

    companion object {
        private val WIDEVINE_UUID = UUID(
            -0x121074568629b532L,
            -0x5c37d8232ae2de13L
        )
    }
}