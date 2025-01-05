package com.yawl.os.pistachio.core

import javax.inject.Inject

interface PropertyRepository {
    fun get(property: String): String
}

class Property @Inject constructor(
) : PropertyRepository {
    override fun get(property: String): String {
        return runCatching {
            ProcessBuilder(PATH, property)
                .redirectErrorStream(true)
                .start()
                .inputStream
                .bufferedReader()
                .use { it.readLine() }
        }.getOrElse { EMPTY }
    }

    companion object {
        private const val PATH = "/system/bin/getprop"
        private const val EMPTY = ""
    }
}
