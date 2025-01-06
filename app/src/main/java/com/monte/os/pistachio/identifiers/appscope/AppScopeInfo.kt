package com.monte.os.pistachio.identifiers.appscope

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.provider.Settings
import android.provider.Settings.Secure.ANDROID_ID
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

class AppScopeInfo @Inject constructor(
    private val context: Context
): AppScopeRepository {
    override fun installationDate(): String {
        val timestamp = context.packageManager
            .getPackageInfo(context.packageName,0)
            .firstInstallTime
        return SimpleDateFormat("dd.MM.yyyy hh:mm:ss", Locale.getDefault())
            .apply { timeZone = TimeZone.getTimeZone("UTC") }
            .format(Date(timestamp))
    }

    override fun appId(): String {
        return GetUser.username
    }

    @SuppressLint("HardwareIds")
    override fun androidId(): String {
        return Settings.Secure.getString(
            context.applicationContext.contentResolver,
            ANDROID_ID
        )
    }
}
