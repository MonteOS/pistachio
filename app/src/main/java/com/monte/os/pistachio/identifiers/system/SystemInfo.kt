package com.monte.os.pistachio.identifiers.system

import android.content.Context
import android.net.Uri
import android.os.Build
import com.monte.os.pistachio.identifiers.core.Property
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
    override fun manufacturer(): String {
        return Build.MANUFACTURER
    }

    override fun brand(): String {
        return Build.BRAND
    }

    override fun model(): String {
        return Build.MODEL
    }

    override fun androidVersion(): String {
        return Build.VERSION.RELEASE
    }

    override fun architecture(): String {
        return Shell.cmd("uname -m")
            .exec()
            .out
            .firstOrNull()
            .toString()
    }

    override fun instructionSets(): String {
        return Build.SUPPORTED_ABIS.toList().toString()
    }

    override fun toyboxVersion(): String {
        return Shell.cmd("toybox --version")
            .exec()
            .out
            .firstOrNull()
            .toString()
    }

    override fun api(): String {
        return Build.VERSION.SDK_INT.toString()
    }

    override fun device(): String {
        return Build.DEVICE
    }

    override fun product(): String {
        return Build.PRODUCT
    }

    override fun board(): String {
        return Build.BOARD
    }

    override fun platform(): String {
        return property.get("ro.board.platform")
    }

    override fun build(): String {
        return Build.ID
    }

    override fun javaVM(): String {
        val javaVmName = System.getProperty("java.vm.name")
        val javaVmVersion = System.getProperty("java.vm.version")
        return "$javaVmName $javaVmVersion"
    }

    override fun security(): String {
        return Build.VERSION.SECURITY_PATCH
    }

    override fun baseband(): String {
        return Build.getRadioVersion()
    }

    override fun buildType(): String {
        return Build.TYPE
    }

    override fun tags(): String {
        return Build.TAGS
    }

    override fun incremental(): String {
        return Build.VERSION.INCREMENTAL
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

    override fun fingerprint(): String {
        return Build.FINGERPRINT
    }

    override fun buildDate(): String {
        return SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            .apply { timeZone = TimeZone.getTimeZone("UTC") }
            .format(Date(Build.TIME))
    }

    override fun builder(): String {
        return "${Build.USER}@${Build.HOST}"
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

    override fun systemServices(): List<String> {
        return Shell.cmd("service list").exec().out
    }

    override fun systemSettings(): List<SystemSetting> {
        val settings = mutableListOf<SystemSetting>()
        val uri = Uri.parse("content://settings/system")
        val cursor = context.contentResolver.query(
            uri, null, null,
            null, null
        )
        while (cursor?.moveToNext() == true) {
            val new = SystemSetting(
                id = cursor.getString(0),
                name = cursor.getString(1),
                value = cursor.getString(2) ?: ""
            )
            if (new.value.isNotEmpty()) {
                settings.add(new)
            }
        }
        cursor?.close()
        return settings
    }

    override fun globalSettings(): List<SystemSetting> {
        val settings = mutableListOf<SystemSetting>()
        val uri = Uri.parse("content://settings/global")
        val cursor = context.contentResolver.query(
            uri, null, null,
            null, null
        )
        while (cursor?.moveToNext() == true) {
            val new = SystemSetting(
                id = cursor.getString(0),
                name = cursor.getString(1),
                value = cursor.getString(2) ?: ""
            )
            if (new.value.isNotEmpty()) {
                settings.add(new)
            }
        }
        cursor?.close()
        return settings
    }
}