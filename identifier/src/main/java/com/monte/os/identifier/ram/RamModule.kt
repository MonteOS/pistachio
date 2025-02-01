package com.monte.os.identifier.ram

import android.content.Context
import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers
import javax.inject.Inject

class RamModule @Inject constructor(
    private val context: Context
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        return listOf(
        )
    }
}
