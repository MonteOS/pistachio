package com.monte.os.pistachio.main.di

import android.content.ContentResolver
import com.monte.os.identifier.GlobalDeviceSettings
import com.monte.os.pistachio.Phone
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object Identifiers {

    @Provides
    @Singleton
    internal fun providePhoneIdentifiers(
        contentResolver: ContentResolver
    ): Phone {
        return Phone.Base(
            globalDeviceSettings = GlobalDeviceSettings(
                contentResolver = contentResolver
            )
        )
    }

}