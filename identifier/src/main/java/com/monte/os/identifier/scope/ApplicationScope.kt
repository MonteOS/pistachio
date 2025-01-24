package com.monte.os.identifier.scope

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings
import android.provider.Settings.Secure.ANDROID_ID
import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import com.topjohnwu.superuser.Shell
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject

class ApplicationScope @Inject constructor(
    private val context: Context
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
            Item("Installation date", installationDate()),
            Item("Android ID", androidId()),
            Item("User and group ID", fullAppId()),
        )
    }

    private fun installationDate(): String {
        val timestamp = context.packageManager
            .getPackageInfo(context.packageName, 0)
            .firstInstallTime
        return SimpleDateFormat("dd.MM.yyyy hh:mm:ss", Locale.getDefault())
            .apply { timeZone = TimeZone.getTimeZone("UTC") }
            .format(Date(timestamp))
    }

    private fun fullAppId(): String {
        return Shell.cmd("id")
            .exec()
            .out
            .firstOrNull() ?: ""
    }

    @SuppressLint("HardwareIds")
    private fun androidId(): String {
        return Settings.Secure.getString(
            context.applicationContext.contentResolver,
            ANDROID_ID
        )
    }
}