package com.yawl.os.pistachio.identifiers.appscope

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.provider.Settings.Secure.ANDROID_ID
import javax.inject.Inject

class AppScopeInfo @Inject constructor(
    private val context: Context
): AppScopeRepository {

    @SuppressLint("HardwareIds")
    override fun androidId(): String {
        return Settings.Secure.getString(
            context.applicationContext.contentResolver,
            ANDROID_ID
        )
    }
}
