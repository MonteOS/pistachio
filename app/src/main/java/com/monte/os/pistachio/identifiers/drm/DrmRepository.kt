package com.monte.os.pistachio.identifiers.drm

interface DrmRepository {

    fun widevineVendor(): String

    fun widevineVersion(): String

    fun widevineAlgorithms(): String

    fun drmId(): String

}
