package com.monte.os.identifier.settings

import android.content.ContentResolver
import android.net.Uri
import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers

abstract class AbstractDeviceSettings(
    private val contentResolver: ContentResolver,
    private val uri: String
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        val items = mutableListOf<Item>()
        val cursor = contentResolver.query(
            Uri.parse(uri), null, null,
            null, null
        )
        while (cursor?.moveToNext() == true) {
            val name = cursor.getString(1)
            val value = cursor.getString(2) ?: ""
            if (value.isNotEmpty()) {
                items.add(Item(name, value))
            }
        }
        cursor?.close()
        return items
    }
}
