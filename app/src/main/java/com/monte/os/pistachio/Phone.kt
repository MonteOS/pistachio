package com.monte.os.pistachio

import com.monte.os.pistachio.main.component.section.Section
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

interface Phone {
    fun identifiers(): Flow<List<Section>>

    suspend fun reload()

    class Base @Inject constructor() : Phone {
        private val result = MutableStateFlow<List<Section>>(
            value = emptyList()
        )

        override fun identifiers() = result

        override suspend fun reload() {
            val props = Section(
                title = "Props",
                description = "Android property list",
                icon = R.drawable.ic_perm_device_information,
                items = emptyList()
            )
            result.value = listOf(
                props,
            )
        }
    }
}
