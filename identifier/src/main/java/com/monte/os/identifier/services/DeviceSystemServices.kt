package com.monte.os.identifier.services

import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import com.topjohnwu.superuser.Shell
import javax.inject.Inject

class DeviceSystemServices @Inject constructor(
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        val output = Shell.cmd("service list").exec().out
        return output.mapNotNull { line ->
            val regex = Regex("""(\w+): \[(.*?)]""")
            regex.find(line)?.let { matchResult ->
                val serviceName = matchResult.groupValues[1]
                val serviceParameters = matchResult.groupValues[2]
                Item(
                    name = serviceName,
                    value = serviceParameters
                )
            }
        }
    }
}
