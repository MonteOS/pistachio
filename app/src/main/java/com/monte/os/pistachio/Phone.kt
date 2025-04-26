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
        private val presentationProperties: ProvideIdentifiers,
        private val deviceProperties: ProvideIdentifiers,
        private val globalDeviceSettings: ProvideIdentifiers,
        private val secureDeviceSettings: ProvideIdentifiers,
        private val systemDeviceSettings: ProvideIdentifiers,
        private val deviceInUseSimCards: ProvideIdentifiers,
        private val deviceDrmModule: ProvideIdentifiers,
        private val applicationScope: ProvideIdentifiers,
        private val deviceSystemServices: ProvideIdentifiers,
        private val displayModule: ProvideIdentifiers,
        private val deviceSystemProps: ProvideIdentifiers,
        private val batteryModule: ProvideIdentifiers,
        private val sensorsModule: ProvideIdentifiers
    ) : Phone {
        private val result = MutableStateFlow<List<Section>>(
            value = emptyList()
        )

        override fun identifiers() = result

        override suspend fun reload() {
            val presentation = Section(
                title = "Presentation",
                description = "Modifier identifiers",
                icon = R.drawable.ic_presentation,
                items = presentationProperties.provide()
            )
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
            val applicationScope = Section(
                title = "This Application",
                description = "Application scope properties",
                icon = R.drawable.ic_android,
                items = applicationScope.provide()
            )
            val systemServices = Section(
                title = "System Services",
                description = "Device system services",
                icon = R.drawable.ic_services,
                items = deviceSystemServices.provide()
            )
            val displayModule = Section(
                title = "Display",
                description = "Device display",
                icon = R.drawable.ic_display,
                items = displayModule.provide()
            )
            val deviceSystemProps = Section(
                title = "System",
                description = "General system properties",
                icon = R.drawable.ic_info,
                items = deviceSystemProps.provide()
            )
            val batteryModule = Section(
                title = "Battery",
                description = "Battery properties",
                icon = R.drawable.ic_battery,
                items = batteryModule.provide()
            )
            val sensorsModule = Section(
                title = "Sensors",
                description = "Device sensors",
                icon = R.drawable.ic_sensors,
                items = sensorsModule.provide()
            )
            result.value = listOf(
                presentation,
                deviceSystemProps,
                applicationScope,
                props,
                globalDeviceSettings,
                systemDeviceSettings,
                secureDeviceSettings,
                deviceInUseSimCards,
                deviceDrmModule,
                systemServices,
                displayModule,
                batteryModule,
                sensorsModule
            )
        }
    }
}
