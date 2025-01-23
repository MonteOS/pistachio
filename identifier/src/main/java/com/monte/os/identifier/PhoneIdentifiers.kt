package com.monte.os.identifier

import com.monte.os.identifier.data.SystemIdentifiers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

interface PhoneIdentifiers {
    fun data(): Flow<List<Section>>

    suspend fun reload()
}

class PhoneIdentifiersImpl @Inject constructor(
    private val system: SystemIdentifiers
) : PhoneIdentifiers {

    private val result = MutableStateFlow<List<Section>>(
        value = emptyList()
    )

    override fun data() = result

    override suspend fun reload() {
        result.value = listOf(Section(
            name = "System",
            items = system.list()
        ))
    }
}
