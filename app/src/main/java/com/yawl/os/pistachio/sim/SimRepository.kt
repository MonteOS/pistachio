package com.yawl.os.pistachio.sim

interface SimRepository {

    fun sim(): List<SimData>

}

data class SimData(
    val operatorName: String,
    val operatorCode: String,
    val country: String,
    val countryCode: String
)
