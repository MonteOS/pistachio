package com.monte.os.pistachio.identifiers.system

data class SystemSetting(
    val id: String,
    val name: String,
    val value: String
) {
    override fun toString(): String {
        return "$name : $value"
    }
}
