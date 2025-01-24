package com.monte.os.identifier.data.system

import android.content.Context
import android.net.Uri
import android.os.Build
import com.monte.os.identifier.data.core.Property
import com.topjohnwu.superuser.Shell
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject


class SystemInfo @Inject constructor(
    private val context: Context,
    private val property: Property
) : SystemRepository {
    override fun architecture(): String {
        return Shell.cmd("uname -m")
            .exec()
            .out
            .firstOrNull()
            .toString()
    }

    override fun toyboxVersion(): String {
        return Shell.cmd("toybox --version")
            .exec()
            .out
            .firstOrNull()
            .toString()
    }

    override fun platform(): String {
        return property.get("ro.board.platform")
    }

    override fun javaVM(): String {
        val javaVmName = System.getProperty("java.vm.name")
        val javaVmVersion = System.getProperty("java.vm.version")
        return "$javaVmName $javaVmVersion"
    }

    override fun security(): String {
        return Build.VERSION.SECURITY_PATCH
    }

    override fun description(): String {
        return property.get("ro.build.description")
    }

    override fun kernelVersion(): String {
        val osVersion = Shell.cmd("uname -r")
            .exec()
            .out
            .firstOrNull()
        val osBuildTime = Shell.cmd("uname -v")
            .exec()
            .out
            .firstOrNull()
        return "$osVersion $osBuildTime"
    }

    override fun buildDate(): String {
        return SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            .apply { timeZone = TimeZone.getTimeZone("UTC") }
            .format(Date(Build.TIME))
    }

    override fun language(): String {
        return Locale.getDefault().displayLanguage
    }

    override fun timezone(): String {
        val currentLocalTime = Calendar.getInstance(
            TimeZone.getTimeZone("GMT"), Locale.getDefault()
        ).time
        val date = SimpleDateFormat("z", Locale.getDefault())
        val localTime = date.format(currentLocalTime)
        val displayName = TimeZone.getDefault().displayName
        return "$displayName ($localTime)"
    }

    override fun allProperties(): List<String> {
        return property.all()
    }
}