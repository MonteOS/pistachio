package com.monte.os.identifier.data.drm

interface DrmRepository {

    fun widevineVendor(): String

    fun widevineVersion(): String

    fun widevineAlgorithms(): String

    fun drmId(): String

}
