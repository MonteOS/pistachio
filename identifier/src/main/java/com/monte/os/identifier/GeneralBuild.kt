package com.monte.os.identifier

import android.os.Build

object GeneralBuild {

    val manufacturer = Build.MANUFACTURER

    val brand = Build.BRAND

    val model = Build.MODEL

    val device = Build.DEVICE

    val product = Build.PRODUCT

    val board = Build.BOARD

    val build = Build.ID

    val securityPatch = Build.VERSION.SECURITY_PATCH

    val buildType = Build.TYPE

    val tags = Build.TAGS

    val incrementalVersion = Build.VERSION.INCREMENTAL

    val fingerprint = Build.FINGERPRINT

    val builder = "${Build.USER}@${Build.HOST}"

    val androidVersion = Build.VERSION.RELEASE

    val instructionSets = Build.SUPPORTED_ABIS.toList()

    val api = Build.VERSION.SDK_INT

    val baseband = Build.getRadioVersion()
}
