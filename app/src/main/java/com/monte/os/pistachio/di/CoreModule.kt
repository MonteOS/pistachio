package com.monte.os.pistachio.di

import com.monte.os.pistachio.ui.DispatchersList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object CoreModule {

    @Provides
    @Singleton
    internal fun providesDispatchers(
    ): DispatchersList {
        return DispatchersList.Base()
    }

}