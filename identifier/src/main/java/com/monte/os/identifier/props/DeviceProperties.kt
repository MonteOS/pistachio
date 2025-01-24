package com.monte.os.identifier.props

import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import com.topjohnwu.superuser.Shell
import javax.inject.Inject

class DeviceProperties @Inject constructor(
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        return Shell.cmd(
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
}
