package com.monte.os.pistachio.main.di

import android.content.ContentResolver
import android.content.Context
import com.monte.os.identifier.props.DeviceProperties
import com.monte.os.identifier.settings.GlobalDeviceSettings
import com.monte.os.identifier.settings.SecureDeviceSettings
import com.monte.os.identifier.settings.SystemDeviceSettings
import com.monte.os.identifier.sim.DeviceInUseSimCards
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
        return Phone.Base(
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
            )
        )
    }

}