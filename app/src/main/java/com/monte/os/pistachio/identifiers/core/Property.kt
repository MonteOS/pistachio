package com.monte.os.pistachio.identifiers.core

import com.topjohnwu.superuser.Shell
import javax.inject.Inject

interface PropertyRepository {
    fun get(property: String): String
}

class Property @Inject constructor(
) : PropertyRepository {
    override fun get(property: String): String {
        return Shell.cmd("$PATH $property")
            .exec()
            .out
            .firstOrNull() ?: EMPTY
    }

    companion object {
        private const val PATH = "/system/bin/getprop"
        private const val EMPTY = ""
    }
}
