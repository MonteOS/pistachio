package com.yawl.os.pistachio.system

interface SystemRepository {

    fun manufacturer(): String

    fun brand(): String

    fun model(): String

    fun release(): String

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

    fun gps(): String

    fun bluetooth(): String

    fun buildType(): String

    fun tags(): String

    fun incremental(): String

    fun description(): String

    fun fingerprint(): String

    fun buildDate(): String

    fun builder(): String

    fun language(): String

    fun timezone(): String
}
