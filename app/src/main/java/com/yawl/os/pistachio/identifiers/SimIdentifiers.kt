package com.yawl.os.pistachio.identifiers

import com.yawl.os.pistachio.identifiers.sim.SimRepository
import javax.inject.Inject

interface SimIdentifiers {

    fun list(): List<Pair<String, String>>

    class Base @Inject constructor(
        private val repository: SimRepository
    ) : SimIdentifiers {
        override fun list(): List<Pair<String, String>> {
            val data = repository.sim()
            return listOf(
                "SIM operator name" to data.operatorName,
                "SIM operator code" to data.operatorCode,
                "SIM Country" to data.country,
                "SIM Country Code" to data.countryCode,
            )
        }
    }
}
