package com.monte.os.identifier

import android.content.ContentResolver
import android.net.Uri
import javax.inject.Inject

class GlobalDeviceSettings @Inject constructor(
    private val contentResolver: ContentResolver
) : ProvideIdentifiers {
    override fun provide(): List<Item> {
        val items = mutableListOf<Item>()
        val cursor = contentResolver.query(
            Uri.parse(URI), null, null,
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

    companion object {
        private const val URI = "content://settings/global"
    }
}