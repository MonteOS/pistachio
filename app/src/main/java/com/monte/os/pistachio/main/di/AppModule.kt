package com.monte.os.pistachio.main.di

import android.content.Context
import com.monte.os.identifier.data.appscope.AppScopeInfo
import com.monte.os.identifier.data.appscope.AppScopeRepository
import com.monte.os.identifier.data.core.Property
import com.monte.os.identifier.data.core.PropertyRepository
import com.monte.os.identifier.data.drm.DrmInfo
import com.monte.os.identifier.data.drm.DrmRepository
import com.monte.os.identifier.data.screen.ScreenInfo
import com.monte.os.identifier.data.screen.ScreenRepository
import com.monte.os.identifier.sim.SimInfo
import com.monte.os.identifier.sim.ProvideSIM
import com.monte.os.identifier.data.system.SystemInfo
import com.monte.os.identifier.data.system.SystemRepository
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
    ): ProvideSIM {
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