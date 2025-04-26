package com.monte.os.identifier.sensors

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import com.monte.os.identifier.Item
import com.monte.os.identifier.ProvideIdentifiers

class DeviceSensorsModule(
    context: Context
) : ProvideIdentifiers {

    private val manager = context.getSystemService(
        Context.SENSOR_SERVICE
    ) as SensorManager

    override fun provide(): List<Item> {
        val list = manager.getSensorList(Sensor.TYPE_ALL)
            .map { Item(it.name, it.stringType) }
        return list
    }
}
