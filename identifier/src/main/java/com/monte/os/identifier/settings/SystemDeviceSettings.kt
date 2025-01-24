package com.monte.os.identifier.settings

import android.content.ContentResolver
import javax.inject.Inject

class SystemDeviceSettings @Inject constructor(
    contentResolver: ContentResolver
) : AbstractDeviceSettings(
    contentResolver = contentResolver,
    uri = "content://settings/system"
)
