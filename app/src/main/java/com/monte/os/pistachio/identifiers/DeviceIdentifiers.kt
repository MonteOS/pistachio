package com.monte.os.pistachio.identifiers

import com.monte.os.pistachio.identifiers.appscope.AppScopeRepository
import com.monte.os.pistachio.identifiers.drm.DrmRepository
import javax.inject.Inject

interface DeviceIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val drm: DrmRepository,
        private val appScope: AppScopeRepository,
    ): DeviceIdentifiers {
        override fun list(): List<Pair<String, String>> {
            return listOf(
                "DRM ID" to drm.drmId(),
                "Android ID" to appScope.androidId(),
            )
        }
    }
}
