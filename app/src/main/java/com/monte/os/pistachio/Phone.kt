package com.monte.os.pistachio

import com.monte.os.identifier.ProvideIdentifiers
import com.monte.os.identifier.drm.DeviceDrmModule
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
        private val systemDeviceSettings: ProvideIdentifiers,
        private val deviceInUseSimCards: ProvideIdentifiers,
        private val deviceDrmModule: ProvideIdentifiers
    ) : Phone {
        private val result = MutableStateFlow<List<Section>>(
            value = emptyList()
        )

        override fun identifiers() = result

        override suspend fun reload() {
            val props = Section(
                title = "Properties",
                description = "Device properties list",
                icon = R.drawable.ic_perm_device_information,
                items = deviceProperties.provide()
            )
            val globalDeviceSettings = Section(
                title = "Global Settings",
                description = "Global device settings",
                icon = R.drawable.ic_phone,
                items = globalDeviceSettings.provide()
            )
            val systemDeviceSettings = Section(
                title = "System Settings",
                description = "System device settings",
                icon = R.drawable.ic_phone,
                items = systemDeviceSettings.provide()
            )
            val secureDeviceSettings = Section(
                title = "Secure Settings",
                description = "Secure device settings",
                icon = R.drawable.ic_secure,
                items = secureDeviceSettings.provide()
            )
            val deviceInUseSimCards = Section(
                title = "SIM",
                description = "Currently used SIM cards",
                icon = R.drawable.ic_sim_card,
                items = deviceInUseSimCards.provide()
            )
            val deviceDrmModule = Section(
                title = "DRM",
                description = "Device DRM module",
                icon = R.drawable.ic_live_tv,
                items = deviceDrmModule.provide()
            )
            result.value = listOf(
                props,
                globalDeviceSettings,
                systemDeviceSettings,
                secureDeviceSettings,
                deviceInUseSimCards,
                deviceDrmModule
            )
        }
    }
}
