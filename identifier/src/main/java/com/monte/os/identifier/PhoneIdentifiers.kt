package com.monte.os.identifier

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

interface PhoneIdentifiers {
    fun data(): Flow<List<Section>>
}

class PhoneIdentifiersImpl @Inject constructor(
) : PhoneIdentifiers {
    override fun data(): Flow<List<Section>> {
        return flowOf()
    }
}
