package com.monte.os.identifier.system

import android.os.Build
import com.topjohnwu.superuser.Shell
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject


class SystemRepositoryImpl @Inject constructor(
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
}
