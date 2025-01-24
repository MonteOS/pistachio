package com.monte.os.identifier.battery

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import javax.inject.Inject

class BatteryRepositoryImpl @Inject constructor(
    private val context: Context
) : BatteryRepository {
    private val batteryStatus: Intent? = IntentFilter(
        Intent.ACTION_BATTERY_CHANGED
    ).let { context.registerReceiver(null, it) }

    override fun level(): Float {
        return batteryStatus?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            level * 100 / scale.toFloat()
        } ?: 0f
    }
}