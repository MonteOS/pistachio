package com.monte.os.identifier

import com.monte.os.identifier.drm.DrmRepository
import javax.inject.Inject

interface DrmIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val repository: DrmRepository
    ) : DrmIdentifiers {
        override fun list(): List<Pair<String, String>> {
            return listOf(
                "DRM ID" to repository.drmId(),
                "Widevine Vendor" to repository.widevineVendor(),
                "Widevine Version" to repository.widevineVersion(),
                "Widevine Algorithms" to repository.widevineAlgorithms(),
            )
        }
    }
}