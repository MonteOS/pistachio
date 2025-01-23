package com.monte.os.pistachio.main.di

import com.monte.os.identifier.PhoneIdentifiers
import com.monte.os.identifier.PhoneIdentifiersImpl
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
    ): PhoneIdentifiers {
        return PhoneIdentifiersImpl()
    }

}