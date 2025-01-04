package com.yawl.os.pistachio.screen

interface ScreenRepository {

    fun resolution(): String

    fun ratio(): String

    fun diagonal(): String

    fun size(): String

    fun density(): String

    fun xDPI(): String

    fun yDPI(): String

    fun ppi(): String

    fun refreshRate(): String

    fun modes(): String

}
