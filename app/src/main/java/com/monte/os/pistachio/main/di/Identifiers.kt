package com.monte.os.pistachio.main.di

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
    ): Phone {
        return Phone.Base()
    }

}