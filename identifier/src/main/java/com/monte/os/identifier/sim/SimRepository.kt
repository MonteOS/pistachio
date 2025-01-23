package com.monte.os.identifier.sim

interface SimRepository {

    fun sim(): SimData

}

data class SimData(
    val operatorName: String,
    val operatorCode: String,
    val country: String,
    val countryCode: String
)
