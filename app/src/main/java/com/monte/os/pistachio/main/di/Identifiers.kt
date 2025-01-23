package com.monte.os.pistachio.main.di

import com.monte.os.identifier.data.AppLifetimeScopeIdentifiers
import com.monte.os.identifier.data.BuildIdentifiers
import com.monte.os.identifier.data.DeviceIdentifiers
import com.monte.os.identifier.data.DisplayIdentifiers
import com.monte.os.identifier.data.DrmIdentifiers
import com.monte.os.identifier.data.SimIdentifiers
import com.monte.os.identifier.data.SystemIdentifiers
import com.monte.os.identifier.data.TimeAndDateIdentifiers
import com.monte.os.identifier.data.appscope.AppScopeRepository
import com.monte.os.identifier.data.drm.DrmRepository
import com.monte.os.identifier.data.screen.ScreenRepository
import com.monte.os.identifier.data.sim.SimRepository
import com.monte.os.identifier.data.system.SystemRepository
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
        systemIdentifiers: SystemIdentifiers
    ): PhoneIdentifiers {
        return PhoneIdentifiersImpl(systemIdentifiers)
    }

    @Provides
    @Singleton
    internal fun provideBuildIdentifiers(
        repository: SystemRepository
    ): BuildIdentifiers {
        return BuildIdentifiers.Base(repository)
    }

    @Provides
    @Singleton
    internal fun provideDeviceIdentifiers(
        appScope: AppScopeRepository,
    ): DeviceIdentifiers {
        return DeviceIdentifiers.Base(appScope)
    }

    @Provides
    @Singleton
    internal fun provideDisplayIdentifiers(
        repository: ScreenRepository
    ): DisplayIdentifiers {
        return DisplayIdentifiers.Base(repository)
    }

    @Provides
    @Singleton
    internal fun provideSimIdentifiers(
        repository: SimRepository
    ): SimIdentifiers {
        return SimIdentifiers.Base(repository)
    }

    @Provides
    @Singleton
    internal fun provideSystemIdentifiers(
        repository: SystemRepository
    ): SystemIdentifiers {
        return SystemIdentifiers.Base(repository)
    }


    @Provides
    @Singleton
    internal fun provideTimeAndDateIdentifiers(
        repository: SystemRepository
    ): TimeAndDateIdentifiers {
        return TimeAndDateIdentifiers.Base(repository)
    }

    @Provides
    @Singleton
    internal fun provideDRMIdentifiers(
        repository: DrmRepository
    ): DrmIdentifiers {
        return DrmIdentifiers.Base(repository)
    }


    @Provides
    @Singleton
    internal fun provideAppLifetimeIdentifiers(
        repository: AppScopeRepository
    ): AppLifetimeScopeIdentifiers {
        return AppLifetimeScopeIdentifiers.Base(repository)
    }

}