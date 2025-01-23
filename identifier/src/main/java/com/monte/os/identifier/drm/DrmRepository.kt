package com.monte.os.identifier.drm

interface DrmRepository {

    fun widevineVendor(): String

    fun widevineVersion(): String

    fun widevineAlgorithms(): String

    fun drmId(): String

}
