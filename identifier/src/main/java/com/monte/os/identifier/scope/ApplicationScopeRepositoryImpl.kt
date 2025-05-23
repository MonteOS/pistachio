package com.monte.os.identifier.scope

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.provider.Settings.Secure.ANDROID_ID
import com.topjohnwu.superuser.Shell
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

class ApplicationScopeRepositoryImpl @Inject constructor(
    private val context: Context
): ApplicationScopeRepository {
    override fun installationDate(): String {
        val timestamp = context.packageManager
            .getPackageInfo(context.packageName, 0)
            .firstInstallTime
        return SimpleDateFormat("dd.MM.yyyy hh:mm:ss", Locale.getDefault())
            .apply { timeZone = TimeZone.getTimeZone("UTC") }
            .format(Date(timestamp))
    }

    override fun fullAppId(): String {
        return Shell.cmd("id")
            .exec()
            .out
            .firstOrNull() ?: ""
    }

    @SuppressLint("HardwareIds")
    override fun androidId(): String {
        return Settings.Secure.getString(
            context.applicationContext.contentResolver,
            ANDROID_ID
        )
    }
}
