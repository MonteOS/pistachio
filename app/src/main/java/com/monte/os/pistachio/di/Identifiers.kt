package com.monte.os.pistachio.di

import com.monte.os.pistachio.identifiers.BuildIdentifiers
import com.monte.os.pistachio.identifiers.DeviceIdentifiers
import com.monte.os.pistachio.identifiers.DisplayIdentifiers
import com.monte.os.pistachio.identifiers.SimIdentifiers
import com.monte.os.pistachio.identifiers.SystemIdentifiers
import com.monte.os.pistachio.identifiers.TimeAndDateIdentifiers
import com.monte.os.pistachio.identifiers.appscope.AppScopeRepository
import com.monte.os.pistachio.identifiers.drm.DrmRepository
import com.monte.os.pistachio.identifiers.screen.ScreenRepository
import com.monte.os.pistachio.identifiers.sim.SimRepository
import com.monte.os.pistachio.identifiers.system.SystemRepository
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
    internal fun provideBuildIdentifiers(
        repository: SystemRepository
    ): BuildIdentifiers {
        return BuildIdentifiers.Base(repository)
    }

    @Provides
    @Singleton
    internal fun provideDeviceIdentifiers(
        drm: DrmRepository,
        appScope: AppScopeRepository,
    ): DeviceIdentifiers {
        return DeviceIdentifiers.Base(
            drm,
            appScope
        )
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

}