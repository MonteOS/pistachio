package com.monte.os.pistachio.di

import android.content.ContentResolver
import android.content.Context
import com.monte.os.pistachio.core.DispatchersList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    internal fun providesContentResolver(
        @ApplicationContext context: Context
    ): ContentResolver {
        return context.contentResolver
    }
}
