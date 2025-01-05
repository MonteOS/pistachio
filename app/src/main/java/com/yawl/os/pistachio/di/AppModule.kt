package com.yawl.os.pistachio.di

import android.content.Context
import com.yawl.os.pistachio.appscope.AppScopeInfo
import com.yawl.os.pistachio.appscope.AppScopeRepository
import com.yawl.os.pistachio.core.Property
import com.yawl.os.pistachio.core.PropertyRepository
import com.yawl.os.pistachio.drm.DrmInfo
import com.yawl.os.pistachio.drm.DrmRepository
import com.yawl.os.pistachio.screen.ScreenInfo
import com.yawl.os.pistachio.screen.ScreenRepository
import com.yawl.os.pistachio.sim.SimInfo
import com.yawl.os.pistachio.sim.SimRepository
import com.yawl.os.pistachio.system.SystemInfo
import com.yawl.os.pistachio.system.SystemRepository
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
        property: Property
    ): SystemRepository {
        return SystemInfo(property)
    }

    @Provides
    @Singleton
    internal fun providesScreenRepository(
        @ApplicationContext context: Context
    ): ScreenRepository {
        return ScreenInfo(context)
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