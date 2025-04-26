package com.monte.os.pistachio.di

import android.content.ContentResolver
import android.content.Context
import com.monte.os.identifier.battery.BatteryModule
import com.monte.os.identifier.battery.BatteryRepositoryImpl
import com.monte.os.identifier.display.DeviceDisplayModule
import com.monte.os.identifier.display.ScreenRepositoryImpl
import com.monte.os.identifier.drm.DeviceDrmModule
import com.monte.os.identifier.drm.DrmRepositoryImpl
import com.monte.os.identifier.props.DeviceProperties
import com.monte.os.identifier.research.ResearchIdentifiers
import com.monte.os.identifier.scope.ApplicationScope
import com.monte.os.identifier.scope.ApplicationScopeRepositoryImpl
import com.monte.os.identifier.sensors.DeviceSensorsModule
import com.monte.os.identifier.services.DeviceSystemServices
import com.monte.os.identifier.settings.GlobalDeviceSettings
import com.monte.os.identifier.settings.SecureDeviceSettings
import com.monte.os.identifier.settings.SystemDeviceSettings
import com.monte.os.identifier.sim.DeviceInUseSimCards
import com.monte.os.identifier.system.DeviceSystemProps
import com.monte.os.identifier.system.SystemRepositoryImpl
import com.monte.os.pistachio.Phone
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object Identifiers {

    @Provides
    @Singleton
    internal fun providePhoneIdentifiers(
        contentResolver: ContentResolver,
        @ApplicationContext context: Context,
    ): Phone {
        val appScopeRepository = ApplicationScopeRepositoryImpl(
            context = context
        )
        val drmRepository = DrmRepositoryImpl()
        val batteryRepository = BatteryRepositoryImpl(
            context = context
        )
        return Phone.Base(
            presentationProperties = ResearchIdentifiers(
                appScopeRepository = appScopeRepository,
                drmRepository = drmRepository,
                batteryRepository = batteryRepository
            ),
            deviceProperties = DeviceProperties(),
            globalDeviceSettings = GlobalDeviceSettings(
                contentResolver = contentResolver
            ),
            systemDeviceSettings = SystemDeviceSettings(
                contentResolver = contentResolver
            ),
            secureDeviceSettings = SecureDeviceSettings(
                contentResolver = contentResolver
            ),
            deviceInUseSimCards = DeviceInUseSimCards(
                context = context
            ),
            deviceDrmModule = DeviceDrmModule(
                repository = drmRepository
            ),
            applicationScope = ApplicationScope(
                repository = appScopeRepository
            ),
            deviceSystemServices = DeviceSystemServices(),
            displayModule = DeviceDisplayModule(
                repository = ScreenRepositoryImpl(
                    context = context
                )
            ),
            deviceSystemProps = DeviceSystemProps(
                repository = SystemRepositoryImpl()
            ),
            batteryModule = BatteryModule(
                repository = batteryRepository
            ),
            sensorsModule = DeviceSensorsModule(
                context = context
            )
        )
    }
}
