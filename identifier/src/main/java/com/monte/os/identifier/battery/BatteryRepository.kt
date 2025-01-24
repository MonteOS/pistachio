package com.monte.os.identifier.battery

interface BatteryRepository {
    fun cyclesCount(): Int

    fun startedCapacity(): Int

    fun estimatedCapacity(): Int

    fun level(): Float
}