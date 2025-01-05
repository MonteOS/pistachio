package com.yawl.os.pistachio.identifiers.sim

import android.content.Context
import android.telephony.TelephonyManager
import com.yawl.os.pistachio.R
import javax.inject.Inject

class SimInfo @Inject constructor(
    private val context: Context
) : SimRepository {
    override fun sim(): List<SimData> {
        val telephony = context.getSystemService(
            Context.TELEPHONY_SERVICE
        ) as TelephonyManager
        val simCountryIso = telephony.simCountryIso.uppercase()
        val countryCode = context
            .resources
            .getStringArray(R.array.country_code)
            .map { it.split(",") }
            .find { it[1] == simCountryIso }
            ?.firstOrNull() ?: ""

        return listOf(
            SimData(
                operatorName = telephony.simOperatorName,
                operatorCode = telephony.simOperator,
                country = simCountryIso,
                countryCode = countryCode
            )
        )
    }
}