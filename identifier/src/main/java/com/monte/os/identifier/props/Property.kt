package com.monte.os.identifier.props

import com.topjohnwu.superuser.Shell

object Property {
    fun all(): List<String> = Shell
        .cmd(PATH)
        .exec()
        .out

    fun get(name: String) = Shell
        .cmd("$PATH $name")
        .exec()
        .out
        .firstOrNull() ?: ""

    private const val PATH =
        "/system/bin/getprop"
}
