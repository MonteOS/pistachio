package com.monte.os.pistachio.identifiers.system

interface SystemRepository {

    fun manufacturer(): String

    fun brand(): String

    fun model(): String

    fun androidVersion(): String

    fun architecture(): String

    fun instructionSets(): String

    fun toyboxVersion(): String

    fun api(): String

    fun device(): String

    fun product(): String

    fun board(): String

    fun platform(): String

    fun build(): String

    fun javaVM(): String

    fun security(): String

    fun kernelVersion(): String

    fun baseband(): String

    fun buildType(): String

    fun tags(): String

    fun incremental(): String

    fun description(): String

    fun fingerprint(): String

    fun buildDate(): String

    fun builder(): String

    fun language(): String

    fun timezone(): String

    fun systemServices(): List<String>

    fun systemSettings(): List<SystemSetting>

    fun globalSettings(): List<SystemSetting>
}
