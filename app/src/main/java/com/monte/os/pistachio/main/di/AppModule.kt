package com.monte.os.pistachio.main.di

import android.content.Context
import com.monte.os.identifier.appscope.AppScopeInfo
import com.monte.os.identifier.appscope.AppScopeRepository
import com.monte.os.identifier.core.Property
import com.monte.os.identifier.core.PropertyRepository
import com.monte.os.identifier.drm.DrmInfo
import com.monte.os.identifier.drm.DrmRepository
import com.monte.os.identifier.screen.ScreenInfo
import com.monte.os.identifier.screen.ScreenRepository
import com.monte.os.identifier.sim.SimInfo
import com.monte.os.identifier.sim.SimRepository
import com.monte.os.identifier.system.SystemInfo
import com.monte.os.identifier.system.SystemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {

    @Provides
    @Singleton
    internal fun provideProperty(): PropertyRepository {
        return Property()
    }

    @Provides
    @Singleton
    internal fun providesSystemRepository(
        @ApplicationContext context: Context,
        property: Property
    ): SystemRepository {
        return SystemInfo(context, property)
    }

    @Provides
    @Singleton
    internal fun providesScreenRepository(
        @ApplicationContext context: Context,
        property: Property
    ): ScreenRepository {
        return ScreenInfo(context, property)
    }


    @Provides
    @Singleton
    internal fun providesSimRepository(
        @ApplicationContext context: Context
    ): SimRepository {
        return SimInfo(context)
    }

    @Provides
    @Singleton
    internal fun providesDrmRepository(
    ): DrmRepository {
        return DrmInfo()
    }

    @Provides
    @Singleton
    internal fun providesAppScopeRepository(
        @ApplicationContext context: Context
    ): AppScopeRepository {
        return AppScopeInfo(context)
    }

}