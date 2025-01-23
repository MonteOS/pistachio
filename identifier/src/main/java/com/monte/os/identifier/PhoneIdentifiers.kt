package com.monte.os.identifier

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

interface PhoneIdentifiers {
    fun data(): Flow<List<Section>>

    suspend fun reload()
}

class PhoneIdentifiersImpl @Inject constructor(
) : PhoneIdentifiers {

    private val result = MutableStateFlow<List<Section>>(
        value = emptyList()
    )

    override fun data() = result

    override suspend fun reload() {
        result.value = listOf()
    }
}
