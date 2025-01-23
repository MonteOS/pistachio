package com.monte.os.identifier

import com.topjohnwu.superuser.Shell

object Properties {
    val all = Shell.cmd(
        "/system/bin/getprop"
    )
        .exec()
        .out
        .mapNotNull { line ->
            val regex = """\[(.+?)]: \[(.*?)]""".toRegex()
            val matchResult = regex.find(line)
            matchResult?.let {
                val (key, value) = it.destructured
                Item(key, value)
            }
        }
}
