package com.monte.os.identifier.battery

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Build
import javax.inject.Inject
import kotlin.math.roundToInt


class BatteryRepositoryImpl @Inject constructor(
    private val context: Context
) : BatteryRepository {
    private val batteryManager = context.getSystemService(
        Context.BATTERY_SERVICE
    ) as BatteryManager

    private val batteryStatus: Intent? = IntentFilter(
        Intent.ACTION_BATTERY_CHANGED
    ).let { context.registerReceiver(null, it) }

    override fun cyclesCount(): Int? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            batteryStatus?.getIntExtra(BatteryManager.EXTRA_CYCLE_COUNT, 0)
        } else {
            null
        }
    }

    @SuppressLint("PrivateApi")
    override fun startedCapacity(): Int {
        val powerProfileClass = "com.android.internal.os.PowerProfile"
        return try {
            val powerProfile = Class.forName(powerProfileClass)
                .getConstructor(Context::class.java)
                .newInstance(context)

            val batteryCapacity = powerProfile.javaClass
                .getMethod("getBatteryCapacity")
                .invoke(powerProfile) as Double

            batteryCapacity.roundToInt()
        } catch (e: Exception) {
            0
        }
    }

    override fun estimatedCapacity(): Int {
        val chargeCounter = batteryManager.getLongProperty(
            BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER
        )
        val capacity = batteryManager.getLongProperty(
            BatteryManager.BATTERY_PROPERTY_CAPACITY
        )
        return (chargeCounter / capacity / 10).toInt()
    }

    override fun level(): Float {
        return batteryStatus?.let { intent ->
            val level: Int = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1)
            val scale: Int = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1)
            level * 100 / scale.toFloat()
        } ?: 0f
    }
}