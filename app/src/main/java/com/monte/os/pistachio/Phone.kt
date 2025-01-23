package com.monte.os.pistachio

import com.monte.os.identifier.ProvideIdentifiers
import com.monte.os.pistachio.main.component.section.Section
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

interface Phone {
    fun identifiers(): Flow<List<Section>>

    suspend fun reload()

    class Base @Inject constructor(
        private val deviceProperties: ProvideIdentifiers,
        private val globalDeviceSettings: ProvideIdentifiers,
        private val secureDeviceSettings: ProvideIdentifiers,
        private val systemDeviceSettings: ProvideIdentifiers
    ) : Phone {
        private val result = MutableStateFlow<List<Section>>(
            value = emptyList()
        )

        override fun identifiers() = result

        override suspend fun reload() {
            val props = Section(
                title = "Props",
                description = "Android property list",
                icon = R.drawable.ic_perm_device_information,
                items = deviceProperties.provide()
            )
            val globalDeviceSettings = Section(
                title = "Global Settings",
                description = "Global device settings",
                icon = R.drawable.ic_perm_device_information,
                items = globalDeviceSettings.provide()
            )
            val systemDeviceSettings = Section(
                title = "System Settings",
                description = "System device settings",
                icon = R.drawable.ic_perm_device_information,
                items = systemDeviceSettings.provide()
            )
            val secureDeviceSettings = Section(
                title = "Secure Settings",
                description = "Secure device settings",
                icon = R.drawable.ic_perm_device_information,
                items = secureDeviceSettings.provide()
            )
            result.value = listOf(
                props,
                globalDeviceSettings,
                systemDeviceSettings,
                secureDeviceSettings
            )
        }
    }
}
